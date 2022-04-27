package com.recipe.recipeentity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class RecipeentityTest {
	
	

	@Test
	void testGetDateTime() {
		LocalDateTime date =LocalDateTime.parse("2022-04-21T16:01:21.335017");
		LocalDateTime date1 =LocalDateTime.parse("2022-04-21T16:01:21.335017");
		Recipeentity re=new Recipeentity();
		re.setDateTime(date);
		LocalDateTime date2 =re.getDateTime();
		assertEquals(date1,date2);
		

	}

	@Test
	void testSetDateTime() {
		LocalDateTime date =LocalDateTime.parse("2022-04-21T16:01:21.335017");
		LocalDateTime date1 =LocalDateTime.parse("2022-04-21T16:01:21.335017");
		Recipeentity re=new Recipeentity();
		re.setDateTime(date);
		LocalDateTime date2 =re.getDateTime();
		assertEquals(date1,date2);
		
	}
	


	@Test
	void testIsVegetarian() {
		Recipeentity re=new Recipeentity();
		re.setVegetarian(true);
	boolean ans=re.isVegetarian();
		assertEquals(true,ans);
		
	}
	

	@Test
	void testSetVegetarian() {
		Recipeentity re=new Recipeentity();
		re.setVegetarian(false);
		assertEquals(false,re.isVegetarian());
	}

	@Test
	void testGetRecipeId() {
		Recipeentity re=new Recipeentity();
		int res=re.getRecipeId();
		assertEquals(0,res);
	}

	@Test
	void testSetRecipeId() {
		Recipeentity re=new Recipeentity();
		re.setRecipeId(5);
		assertEquals(5,re.getRecipeId());

	}

	@Test
	void testGetRecipeName() {
		Recipeentity re=new Recipeentity();
		re.getRecipeName();
		assertEquals(null,re.getRecipeName());
	}
	

	@Test
	void testSetRecipeName() {
		Recipeentity re=new Recipeentity();
		re.setRecipeName("Beans");
		assertEquals("Beans",re.getRecipeName());
	}

	@Test
	void testGetCookingInstructions() {
		Recipeentity re=new Recipeentity();
		assertEquals(null,re.getCookingInstructions());
	}

	@Test
	void testSetCookingInstructions() {
		Recipeentity re=new Recipeentity();
		re.setCookingInstructions("toss all veges in pan");
		assertEquals("toss all veges in pan",re.getCookingInstructions());
		
	}

	@Test
	void testGetDishsuitable() {
		Recipeentity re=new Recipeentity();
		re.setDishsuitable("5 persons");
		assertEquals("5 persons",re.getDishsuitable());
	}

	@Test
	void testSetDishsuitable() {
		Recipeentity re=new Recipeentity();
		re.setDishsuitable("10 persons");
		assertEquals("10 persons",re.getDishsuitable());
	}

	@Test
	void testGetIngredients() {
		Recipeentity re=new Recipeentity();
		Ingredientsentity ig1=new Ingredientsentity();
		ig1.setIngredientsnames("water,coffee powder,sugar");
		List<Ingredientsentity> li=new ArrayList<>();
		li.add(ig1);
		List<Ingredientsentity> li1=new ArrayList<>();
		li1.add(ig1);
		re.setIngredients(li);
		assertEquals(li1,re.getIngredients());
		
		
	}
	

	@Test
	void testSetIngredients() {
		Recipeentity re=new Recipeentity();
		Ingredientsentity ig1=new Ingredientsentity();
		ig1.setIngredientsnames("watermelon,sugar,icecream");
		List<Ingredientsentity> li=new ArrayList<>();
		li.add(ig1);
		List<Ingredientsentity> li1=new ArrayList<>();
		li1.add(ig1);
		re.setIngredients(li);
		assertEquals(li1,re.getIngredients());
	}

	@Test
	void testRecipeentityLocalDateTimeIntStringListOfIngredientsentityStringBooleanString() {
		Ingredientsentity ig=new Ingredientsentity("popcornseeds");
		List<Ingredientsentity> lii=new ArrayList<>();
		lii.add(ig);
		LocalDateTime date =LocalDateTime.parse("2022-04-23T16:01:21.335017");
		Recipeentity rec1=new Recipeentity(date,1,"Popcorn",lii,"pour popcorn seeds in cooker and wait for 5 min",true,"4 persons");
	}
	@Test
	void testRecipeentity() {
		
	}
	@Test
	void testTostring() {
		Ingredientsentity ig=new Ingredientsentity("popcornseeds");
		List<Ingredientsentity> lii=new ArrayList<>();
		lii.add(ig);
		LocalDateTime date =LocalDateTime.parse("2022-04-25T16:01:21.335017");
		Recipeentity rec1=new Recipeentity(date,5,"Popcorn",lii,"pour popcorn seeds in cooker and wait for 5 min",true,"4 persons");
		//Recipeentity rec2=new Recipeentity(date,2,"Butterpopcorn",lii,"pour popcorn seeds in cooker and wait for 5 min",true,"4 persons");
		rec1.getDateTime();
		rec1.getRecipeId();
		rec1.getRecipeName();
		rec1.getIngredients();
		rec1.getCookingInstructions();
		rec1.isVegetarian();
		rec1.getDishsuitable();
		//assertEquals(rec1.getIngredients(),rec2.getIngredients());
	}
	

}
