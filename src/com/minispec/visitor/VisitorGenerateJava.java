package com.minispec.visitor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

import com.minispec.constants.Config;
import com.minispec.metamodel.Attribute;
import com.minispec.metamodel.Entity;
import com.minispec.metamodel.Model;
import com.minispec.metamodel.type.CollectionType;
import com.minispec.metamodel.type.SimpleType;
import com.minispec.utils.ClassGeneration;

public class VisitorGenerateJava implements IVisitor
{
  protected Model model;
  protected StringBuilder codeJavaBuilder;

  public VisitorGenerateJava()
  {
    this.codeJavaBuilder = new StringBuilder();
  }

  @Override
  public void visitModel(Model model)
  {
    this.model = model;

    for (Entity entity : model.getEntities())
    {
      entity.accept(this);
    }
  }

  @Override
  public void visitEntity(Entity entity)
  {
    // Génération de la classe en String
    this.codeJavaBuilder.append("public class " + entity.getNom() + " {");
    this.codeJavaBuilder.append("\n");

    for (Attribute attribute : entity.getAttributes())
    {
      attribute.accept(this);
    }

    this.codeJavaBuilder.append("\n");
    this.codeJavaBuilder.append(ClassGeneration.generateConstructor(entity, 1));
    this.codeJavaBuilder.append("\n");

    this.codeJavaBuilder.append("\n");
    this.codeJavaBuilder.append(ClassGeneration.generateGettersAndSetters(entity.getAttributes(), 1));

    this.codeJavaBuilder.append("\n");
    this.codeJavaBuilder.append("}");

    // Ecriture de la classe dans un fichier
    this.writeGeneratedClassIntoFile(model.getNom(), entity.getNom(), this.codeJavaBuilder.toString());

    // Nouveau StringBuilder pour les classes suivantes
    this.codeJavaBuilder = new StringBuilder();
  }

  @Override
  public void visitAttribute(Attribute attribute)
  {
    this.codeJavaBuilder.append("\t");
    this.codeJavaBuilder.append(attribute.getType() + " " + attribute.getNom() + ";");
    this.codeJavaBuilder.append("\n");
  }

  protected void writeGeneratedClassIntoFile(String parentFolderName, String filename, String classContent)
  {
    // Création du dossier parent
    File parentFolder = new File(Config.GENERATED_PATH, parentFolderName);
    parentFolder.mkdir();

    // Création du chemin du fichier à générer
    String generatedClassPath = Paths.get(parentFolder.getAbsolutePath(), filename + ".java").toString();

    // Création du fichier et écriture
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(generatedClassPath)))
    {
      writer.write(classContent);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public void visitSimpleType(SimpleType type)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void visitCollection(CollectionType type)
  {
    // TODO Auto-generated method stub

  }
}