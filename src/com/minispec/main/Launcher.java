package com.minispec.main;

import java.net.URISyntaxException;

import com.minispec.metamodel.Model;
import com.minispec.reader.Reader;
import com.minispec.reader.dom.ReaderXmlDom;

public class Launcher
{

  public static void main(String[] args) throws URISyntaxException
  {
//    System.out.println(Launcher.class.getClassLoader().getResource("testClasseSimple.xml").toURI().getPath());
    Reader reader = new ReaderXmlDom("xmlTest/testClasseSimple.xml");
    Model model = reader.loadModel();

    System.out.println(model);
  }
}
