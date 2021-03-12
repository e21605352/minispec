package com.minispec.visitor;

import com.minispec.metamodel.Attribute;
import com.minispec.metamodel.Entity;
import com.minispec.metamodel.Model;
import com.minispec.metamodel.type.CollectionType;
import com.minispec.metamodel.type.SimpleType;

public interface IVisitor
{
  public void visitModel(Model model);

  public void visitEntity(Entity entity);

  public void visitAttribute(Attribute attribute);

  public void visitSimpleType(SimpleType type);

  public void visitCollection(CollectionType type);
}