package com.minispec.utils;

import java.util.ArrayList;
import java.util.List;

import com.minispec.metamodel.Attribute;
import com.minispec.metamodel.Entity;

public class ClassGeneration
{
  private ClassGeneration()
  {
    throw new IllegalStateException("Utility class");
  }

  /**
   * Génère le constructeur d'une Entity avec initialisation de ses attributs.
   * 
   * @param entity
   * @param indentationNumber
   */
  public static String generateConstructor(Entity entity, int indentationNumber)
  {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append(StringUtils.repeat("\t", indentationNumber));
    stringBuilder.append("public " + entity.getNom() + "(");

    List<String> constructorParameters = new ArrayList<>();
    for (Attribute attribute : entity.getAttributes())
    {
      constructorParameters.add(attribute.getType() + " " + attribute.getNom());
    }
    stringBuilder.append(String.join(", ", constructorParameters));

    stringBuilder.append(") {");
    stringBuilder.append("\n");

    for (Attribute attribute : entity.getAttributes())
    {
      stringBuilder.append(StringUtils.repeat("\t", indentationNumber + 1));
      stringBuilder.append("this." + attribute.getNom() + " = " + attribute.getNom() + ";");
      stringBuilder.append("\n");
    }

    stringBuilder.append(StringUtils.repeat("\t", indentationNumber));
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  /**
   * Génère les getters et setters des attributs envoyés en paramètres.
   * 
   * @param attributes
   * @param indentationNumber
   */
  public static String generateGettersAndSetters(List<Attribute> attributes, int indentationNumber)
  {
    StringBuilder stringBuilder = new StringBuilder();

    List<String> methods = new ArrayList<>();
    for (Attribute attribute : attributes)
    {
      methods.add(generateGetter(attribute, indentationNumber));
      methods.add(generateSetter(attribute, indentationNumber));
    }
    stringBuilder.append(String.join("\n\n", methods));

    return stringBuilder.toString();
  }

  /**
   * Génère le getter de l'attribut envoyé en paramètre.
   * 
   * @param attribute
   * @param indentationNumber
   */
  public static String generateGetter(Attribute attribute, int indentationNumber)
  {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append(StringUtils.repeat("\t", indentationNumber));
    stringBuilder
        .append("public " + attribute.getType() + " get" + StringUtils.capitalize(attribute.getNom()) + "() {");
    stringBuilder.append("\n");
    stringBuilder.append(StringUtils.repeat("\t", indentationNumber + 1));
    stringBuilder.append("return " + attribute.getNom() + ";");

    stringBuilder.append("\n");
    stringBuilder.append(StringUtils.repeat("\t", indentationNumber));
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  /**
   * Génère le setter de l'attribut envoyé en paramètre.
   * 
   * @param attribute
   * @param indentationNumber
   */
  public static String generateSetter(Attribute attribute, int indentationNumber)
  {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append(StringUtils.repeat("\t", indentationNumber));
    stringBuilder.append("public void set" + StringUtils.capitalize(attribute.getNom()));
    stringBuilder.append("(" + attribute.getType() + " " + attribute.getNom() + ")");
    stringBuilder.append(" {");

    stringBuilder.append("\n");
    stringBuilder.append(StringUtils.repeat("\t", indentationNumber + 1));
    stringBuilder.append("this." + attribute.getNom() + " = " + attribute.getNom() + ";");

    stringBuilder.append("\n");
    stringBuilder.append(StringUtils.repeat("\t", indentationNumber));
    stringBuilder.append("}");

    return stringBuilder.toString();
  }
}
