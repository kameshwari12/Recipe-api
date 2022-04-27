package com.recipe.recipeentity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity//@Entity annotation specifies that the class is an entity and is mapped to a database table.
public class Recipeentity {
	@CreationTimestamp
	
	private LocalDateTime dateTime;
	

	//@CreatedDate
	//@Column(name="date and time")
	//private LocalDateTime dateAndTime;
	@Id//..@Id annotation specifies the primary key of an entity
	@GeneratedValue(strategy = GenerationType.IDENTITY)//@GeneratedValue provides for the specification of generation strategies for the values of primary keys.
	@Column(name="id")//@Column annotation is used for Adding the column the name in the table of a particular MySQL database.
	private int recipeId;
	@Column(name="recipe")
	private String recipeName;
	@OneToMany(cascade=CascadeType.ALL)//@OneToMany annotation is used to specify one-to-many relationship between two entities is defined by using the @OneToMany annotation in Spring Data JPA
	@JoinColumn(name="Recp_Fk")//@Joincolumn is used to specify the column we'll use for joining an entity association or element collection
	@Column(name="ingridents")
	 private List<Ingredientsentity> ingredients;
	
	@Column(name="Instructions")
	private String cookingInstructions;
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	/*public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}*/

	public Recipeentity(LocalDateTime dateTime, int recipeId, String recipeName, List<Ingredientsentity> ingredients,
			String cookingInstructions, boolean vegetarian, String dishsuitable) {
		super();
		this.dateTime = dateTime;
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.ingredients = ingredients;
		this.cookingInstructions = cookingInstructions;
		this.vegetarian = vegetarian;
		this.dishsuitable = dishsuitable;
	}

	@Column(name="vegetariandish")
	private boolean vegetarian;
	
	@Column(name="quantity")
	private String dishsuitable;
	
	public Recipeentity() {
		
	}
	
/*	public Recipeentity(int recipeId, String recipeName, List<Ingredientsentity> ingredients,
			String cookingInstructions, boolean vegetarian, String dishsuitable) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.ingredients = ingredients;
		this.cookingInstructions = cookingInstructions;
		this.vegetarian = vegetarian;
		this.dishsuitable = dishsuitable;
	}*/



	public boolean isVegetarian() {
		return vegetarian;
	}


	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	
	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getCookingInstructions() {
		return cookingInstructions;
	}

	public void setCookingInstructions(String cookingInstructions) {
		this.cookingInstructions = cookingInstructions;
	}

	public String getDishsuitable() {
		return dishsuitable;
	}

	public void setDishsuitable(String dishsuitable) {
		this.dishsuitable = dishsuitable;
	}

	//@OneToMany(cascade=CascadeType.ALL)
	public List<Ingredientsentity> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredientsentity> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Recipeentity [dateTime=" + dateTime + ", recipeId=" + recipeId + ", recipeName=" + recipeName
				+ ", ingredients=" + ingredients + ", cookingInstructions=" + cookingInstructions + ", vegetarian="
				+ vegetarian + ", dishsuitable=" + dishsuitable + "]";
	}

	
	
	
}
