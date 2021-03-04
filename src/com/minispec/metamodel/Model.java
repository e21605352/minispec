package com.minispec.metamodel;

import java.util.ArrayList;
import java.util.List;

import com.minispec.visitorGenerateJava.IVisitor;

/**
 * Classe representant system dans les documents XML
 */
public class Model
{
  protected String nom;
  protected List<Entity> entities;

  public Model()
  {
    this.entities = new ArrayList<>();
  }

  public void addEntity(Entity entity)
  {
    this.entities.add(entity);
  }

  public void addAllEntities(List<Entity> entities)
  {
    this.entities.addAll(entities);
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

  public List<Entity> getEntities()
  {
    return new ArrayList<>(this.entities);
  }

  public void accept(IVisitor visitor)
  {

  }
}
