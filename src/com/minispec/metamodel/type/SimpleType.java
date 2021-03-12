package com.minispec.metamodel.type;

import com.minispec.visitor.IVisitor;

public class SimpleType extends Type
{

  @Override
  public void accept(IVisitor visitor)
  {
    visitor.visitSimpleType(this);
  }
}
