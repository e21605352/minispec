package com.minispec.metamodel;

import com.minispec.visitorGenerateJava.IVisitor;

public class Attribute
{
  protected String nom;
  protected String type;

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

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public void accept(IVisitor visitor)
  {

  }
}
