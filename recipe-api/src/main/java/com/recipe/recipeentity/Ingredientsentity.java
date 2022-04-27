package com.recipe.recipeentity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity//@Entity annotation specifies that the class is an entity and is mapped to a database table.

public class Ingredientsentity {
	@Id//@Id annotation specifies the primary key of an entity
	@GeneratedValue(strategy=GenerationType.IDENTITY)//@GeneratedValue is used to automatically  generate values for id
	private int Ingredientid;
	
	@Column(name="ingredients")//@Column is used to add the column name in the database.
	private String ingredientsnames;
	
	
	public String getIngredientsnames() {
		return ingredientsnames;
	}
	public void setIngredientsnames(String ingredientsnames) {
		this.ingredientsnames = ingredientsnames;
	}
	//int ingredientid
	
	public Ingredientsentity( String ingredientsnames) {
		super();
		//Ingredientid = ingredientid;
		this.ingredientsnames = ingredientsnames;
	}
	public Ingredientsentity(){}
	
		
	/*public int getIngredientid() {
		return Ingredientid;
	}

	public void setIngredientid(int ingredientid) {
		Ingredientid = ingredientid;
	}

	
*/

}
	

	

	
