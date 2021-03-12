package com.minispec.metamodel.type;

import com.minispec.visitor.IVisitor;

public class CollectionType extends Type
{
  protected Type type;
  protected int size;

  @Override
  public void accept(IVisitor visitor)
  {
    visitor.visitCollection(this);
  }

  public Type getType()
  {
    return type;
  }

  public void setType(Type type)
  {
    this.type = type;
  }

  public int getSize()
  {
    return size;
  }

  public void setSize(int size)
  {
    this.size = size;
  }
}
