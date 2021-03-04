
package com.minispec.reader;

import com.minispec.metamodel.Model;

public abstract class Reader
{
  protected String fileName;

  public Reader(String fileName)
  {
    this.fileName = fileName;
  }

  public abstract Model loadModel();

  public String getFileName()
  {
    return this.fileName;
  }
}
