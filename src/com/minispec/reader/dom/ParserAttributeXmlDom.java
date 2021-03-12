package com.minispec.reader.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.minispec.constants.ConstantsXml;
import com.minispec.metamodel.Attribute;

public class ParserAttributeXmlDom
{

  protected Element element;

  public ParserAttributeXmlDom(Element element)
  {
    this.element = element;
  }

  public List<Attribute> parse()
  {
    List<Attribute> attributes = new ArrayList<>();
    NodeList attributeNodes = this.element.getElementsByTagName(ConstantsXml.ATTRIBUTE_NODE);

    for (int i = 0; i < attributeNodes.getLength(); i++)
    {
      Node attributeNode = attributeNodes.item(i);
      if (attributeNode.getNodeType() == Node.ELEMENT_NODE)
      {
        Element attributeElement = (Element) attributeNode;
        Attribute attribute = new Attribute();
        attribute.setNom(attributeElement.getAttribute(ConstantsXml.ATTRIBUTE_NAME));
        ParserTypeXmlDom parserType = new ParserTypeXmlDom(attributeElement);
        attribute.setType(parserType.parse());

        attributes.add(attribute);
      }
    }

    return attributes;
  }
}
