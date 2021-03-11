package com.minispec.reader.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.minispec.constants.ConstantsXml;
import com.minispec.metamodel.Entity;

public class ParserEntityXmlDom
{

  protected Document document;

  public ParserEntityXmlDom(Document document)
  {
    this.document = document;
  }

  public List<Entity> parse()
  {
    List<Entity> entities = new ArrayList<>();
    NodeList entityNodes = document.getElementsByTagName(ConstantsXml.ENTITY_NODE);

    for (int i = 0; i < entityNodes.getLength(); i++)
    {
      Node contactNode = entityNodes.item(i);

      if (contactNode.getNodeType() == Node.ELEMENT_NODE)
      {
        Element entityElement = (Element) contactNode;

        Entity entity = new Entity();
        entity.setNom(entityElement.getAttribute(ConstantsXml.ENTITY_NAME));

        ParserAttributeXmlDom parserAtribute = new ParserAttributeXmlDom(entityElement);
        entity.addAllAttributes(parserAtribute.parse());

        entities.add(entity);
      }
    }

    return entities;
  }
}
