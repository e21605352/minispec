package com.minispec.metamodel;

import com.minispec.metamodel.type.Type;
import com.minispec.visitor.IVisitable;
import com.minispec.visitor.IVisitor;

public class Attribute implements IVisitable
{
  protected String nom;
  protected Type type;

  // ================================================================================
  // Accesseurs
  // ================================================================================

  public String getNom()
  {
    return nom;
  }

  public void setNom(String nom)
  {
    this.nom = nom;
  }

  public Type getType()
  {
    return type;
  }

  public void setType(Type type)
  {
    this.type = type;
  }

  @Override
  public void accept(IVisitor visitor)
  {
    visitor.visitAttribute(this);
  }

  @Override
  public String toString()
  {
    return "\tAttribut: \n" + "\t\tNom: " + this.nom + "\n" + "\t\tType: " + this.type + "\n";
  }
}
