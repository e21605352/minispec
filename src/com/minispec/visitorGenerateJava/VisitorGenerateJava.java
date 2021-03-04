package com.minispec.visitorGenerateJava;

import com.minispec.metamodel.Attribute;
import com.minispec.metamodel.Entity;
import com.minispec.metamodel.Model;

public class VisitorGenerateJava implements IVisitor
{
  @Override
  public void visitModel(Model model)
  {
    model.accept(this);
  }

  @Override
  public void visitEntity(Entity entity)
  {
    // TODO Auto-generated method stub
    entity.accept(this);
  }

  @Override
  public void visitAttribute(Attribute attribute)
  {
    // TODO Auto-generated method stub
    attribute.accept(this);
  }
}