package com.minispec.reader.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.minispec.constants.ConstantsXml;
import com.minispec.metamodel.Model;
import com.minispec.reader.Reader;

public class ReaderXmlDom extends Reader
{

  public ReaderXmlDom(String fileName)
  {
    super(fileName);
  }

  @Override
  public Model loadModel()
  {
    Model model = new Model();

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    try
    {
      DocumentBuilder documentBuilder = factory.newDocumentBuilder();
      Document document = documentBuilder.parse(fileName);
      document.getDocumentElement().normalize();

      Node modelNode = document.getElementsByTagName(ConstantsXml.SYSTEM_NODE).item(0);
      Element modelElement = (Element) modelNode;
      model.setNom(modelElement.getAttribute(ConstantsXml.SYSTEM_NAME));

      ParserEntityXmlDom parserEntity = new ParserEntityXmlDom(document);
      model.addAllEntities(parserEntity.parse());
    }
    catch (ParserConfigurationException | SAXException | IOException e)
    {
      e.printStackTrace();
    }

    return model;
  }
}
