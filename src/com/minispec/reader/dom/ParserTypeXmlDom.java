package com.minispec.reader.dom;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.minispec.constants.ConstantsXml;
import com.minispec.metamodel.type.CollectionType;
import com.minispec.metamodel.type.SimpleType;
import com.minispec.metamodel.type.Type;

public class ParserTypeXmlDom
{
  protected Element element;
  protected Type type;

  public ParserTypeXmlDom(Element element)
  {
    this.element = element;
  }

  public Type parse()
  {
    Node typeNode = this.element.getElementsByTagName(ConstantsXml.TYPE_NODE).item(0);
    if (typeNode.getNodeType() == Node.ELEMENT_NODE)
    {

      Element typeElement = (Element) typeNode;
      if (typeElement.getElementsByTagName(ConstantsXml.COLLECTION_NODE).item(0) != null)
      {
        // TYPE COLLECTION
        Node collectionTypeNode = typeElement.getElementsByTagName(ConstantsXml.COLLECTION_NODE).item(0);
        if (collectionTypeNode.getNodeType() == Node.ELEMENT_NODE)
        {
          Element collectionTypeElement = (Element) collectionTypeNode;

          CollectionType collectionType = new CollectionType();
          collectionType.setName(collectionTypeElement.getAttribute(ConstantsXml.COLLECTION_NAME));
          collectionType.setSize(Integer.parseInt(collectionTypeElement.getAttribute(ConstantsXml.COLLECTION_SIZE)));

          ParserTypeXmlDom parser = new ParserTypeXmlDom(collectionTypeElement);
          collectionType.setType(parser.parse());

          this.type = collectionType;
        }
      }
      else
      {
        // TYPE SIMPLE
        Node simpleTypeNode = typeElement.getElementsByTagName(ConstantsXml.SIMPLE_NODE).item(0);
        if (simpleTypeNode.getNodeType() == Node.ELEMENT_NODE)
        {
          Element simpleTypeElement = (Element) simpleTypeNode;

          SimpleType simpleType = new SimpleType();
          simpleType.setName(simpleTypeElement.getAttribute(ConstantsXml.SIMPLE_NAME));

          this.type = simpleType;
        }
      }
    }

    return type;
  }
}
