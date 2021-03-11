package com.minispec.visitor;

import com.minispec.metamodel.Attribute;
import com.minispec.metamodel.Entity;
import com.minispec.metamodel.Model;

public class VisitorGenerateJava implements IVisitor
{
	/**
	 * Contient la chaine de charactère generer par le visiteur lors de sa visite
	 */
	protected String javaGenerated;
	
	public VisitorGenerateJava() {
		this.javaGenerated = "";
	}
	
  @Override
  public void visitModel(Model model)
  {
	System.out.println("Visiting...");
    this.javaGenerated += "package " + model.getNom() + ";";
    
    for (Entity entity : model.getEntities()) {
		entity.accept(this);
	}
    
    System.out.println("Finish Visiting. Generated Code: ");
    System.out.println(this.javaGenerated);
  }

  @Override
  public void visitEntity(Entity entity)
  {
	  this.javaGenerated += "\npublic class " + entity.getNom() + "\n{\n";
	  
	  for (Attribute attribute : entity.getAttributes()) {
		  attribute.accept(this);
	  }
	  
	  this.javaGenerated += "}";
	  
  }

  @Override
  public void visitAttribute(Attribute attribute)
  {
	  this.javaGenerated += "\tprotected " + attribute.getType() + " " + attribute.getNom() + ";\n";
  }
  
  
}