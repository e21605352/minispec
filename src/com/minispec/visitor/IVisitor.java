package com.minispec.visitor;

import com.minispec.metamodel.Attribute;
import com.minispec.metamodel.Entity;
import com.minispec.metamodel.Model;

public interface IVisitor
{
  public void visitModel(Model model);

  public void visitEntity(Entity entity);

  public void visitAttribute(Attribute attribute);
}