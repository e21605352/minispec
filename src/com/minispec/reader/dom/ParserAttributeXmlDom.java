package com.minispec.reader.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.minispec.constants.ConstantsXml;
import com.minispec.metamodel.Attribute;

public class ParserAttributeXmlDom
{

  protected Document document;

  public ParserAttributeXmlDom(Document document)
  {
    this.document = document;
  }

  public List<Attribute> parse()
  {
    List<Attribute> attributes = new ArrayList<>();
    NodeList attributeNodes = document.getElementsByTagName(ConstantsXml.ATTRIBUTE_NODE);

    for (int i = 0; i < attributeNodes.getLength(); i++)
    {
      Node attributeNode = attributeNodes.item(i);

      if (attributeNode.getNodeType() == Node.ELEMENT_NODE)
      {
        Element attributeElement = (Element) attributeNode;

        Attribute attribute = new Attribute();
        attribute.setNom(attributeElement.getAttribute(ConstantsXml.ATTRIBUTE_NAME));
        attribute.setType(attributeElement.getAttribute(ConstantsXml.ATTRIBUTE_TYPE));

        attributes.add(attribute);
      }
    }

    return attributes;
  }
}
