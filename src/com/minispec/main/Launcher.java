package com.minispec.main;

import java.net.URISyntaxException;

import com.minispec.metamodel.Model;
import com.minispec.reader.Reader;
import com.minispec.reader.dom.ReaderXmlDom;
import com.minispec.visitor.IVisitor;
import com.minispec.visitor.VisitorGenerateJava;

public class Launcher
{

  public static void main(String[] args) throws URISyntaxException
  {
    Reader reader = new ReaderXmlDom("xmlTest/testClasseSimple2.xml");
    Model model = reader.loadModel();

    IVisitor visitor = new VisitorGenerateJava();
    model.accept(visitor);
  }
}
