package com.minispec.metamodel;

import java.util.ArrayList;
import java.util.List;

import com.minispec.visitorGenerateJava.IVisitor;

public class Entity
{
  protected String nom;
  protected List<Attribute> attributes;

  public Entity()
  {
    this.attributes = new ArrayList<>();
  }

  public Entity(String nom)
  {
    this.nom = nom;
    this.attributes = new ArrayList<>();
  }

  public void addAttribute(Attribute attribute)
  {
    this.attributes.add(attribute);
  }

  public void addAllAttributes(List<Attribute> attributes)
  {
    this.attributes.addAll(attributes);
  }

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

  public List<Attribute> getAttributes()
  {
    return attributes;
  }

  public void setAttributes(List<Attribute> attributes)
  {
    this.attributes = attributes;
  }

  public void accept(IVisitor visitor)
  {

  }
}
