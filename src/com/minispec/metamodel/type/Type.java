package com.minispec.metamodel.type;

import com.minispec.visitor.IVisitable;

public abstract class Type implements IVisitable
{
  protected String name;

  public Type()
  {
    this.name = "";
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }
}
