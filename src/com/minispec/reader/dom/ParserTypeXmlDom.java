package com.minispec.reader.dom;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.minispec.metamodel.Type;

public class ParserTypeXmlDom
{

  protected Element element;

  public ParserTypeXmlDom(Element element)
  {
    this.element = element;
  }

  public Type parse()
  {
    Type type = new Type();
    Node typeNode = this.element.getFirstChild();
    System.out.println(((Element) this.element.getFirstChild()).getTagName());

//    System.out.println(typeNode.getNodeName());
    if (typeNode.getNodeType() == Node.ELEMENT_NODE)
    {
      Element typeElement = (Element) typeNode;
      System.out.println(typeElement.getElementsByTagName("simpleType").getLength());
//      if (typeElement.getElementsByTagName("simpleType").getLength() != 0)
//      {
//        // SIMPLE TYPE
//        Node simpleTypeNode = typeElement.getElementsByTagName("simpleType").item(0);
//        if (simpleTypeNode.getNodeType() == Node.ELEMENT_NODE)
//        {
//          Element simpleTypeElement = (Element) simpleTypeNode;
//          type.setType(type.getType() + simpleTypeElement.getAttribute("type"));
//        }
//      }
//      else
//      {
//        System.out.println("coucou");
//        // COLLECTIONS TYPE
//        Node collectionTypeNode = typeElement.getElementsByTagName("collection").item(0);
//        if (collectionTypeNode.getNodeType() == Node.ELEMENT_NODE)
//        {
//          Element collectionTypeElement = (Element) collectionTypeNode;
//          System.out.println(collectionTypeElement.getAttribute("type"));
//
//          type.setType(type.getType() + collectionTypeElement.getAttribute("type") + "<");
//          ParserTypeXmlDom parser = new ParserTypeXmlDom(this.element);
//          type.setType(type.getType() + parser.parse() + ">");
//        }
//      }
    }

    System.out.println(type.getType());
    return type;

  }
}
