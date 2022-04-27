package com.recipe;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.recipe.recipeentity.Ingredientsentity;
import com.recipe.recipeentity.Recipeentity;
import com.recipe.repository.Reciperepository;
import com.recipe.service.Recipeservice;


@SpringBootTest
class recipeapiApplicationTests {
	@Autowired 
	private Reciperepository reciperepository;
	@Autowired
	private Recipeservice recipeservice ;
	 
	@Test
	void contextLoads() {
		Ingredientsentity ig1=new Ingredientsentity("potato,oil,tomato,salt,chilli");
		List<Ingredientsentity> li=new ArrayList<>();
		li.add(ig1);
		LocalDateTime date =LocalDateTime.parse("2022-04-21T16:01:21.335017");
		Recipeentity recipe1=new Recipeentity(date,1,"potato",li,"keep tossing veges", true,"5 persons");
		reciperepository.save(recipe1);
		//Recipeentity recp2=reciperepository.findById(recipe1.getRecipeId());
		
		List<Recipeentity> r1=(List<Recipeentity>)recipeservice.getAllRecipes();
	//	assertThat(r1.get(2).getRecipeName()).isEqualTo(recipe1.getRecipeName());
		assertEquals("potato",r1.get(0).getRecipeName());
	}
	
	
		@Test
		void testAddNewRecipe() {
		Ingredientsentity ig1=new Ingredientsentity("veges,oil,salt,chilli");
		List<Ingredientsentity> li=new ArrayList<>();
		li.add(ig1);
		LocalDateTime date =LocalDateTime.parse("2022-04-21T16:01:21.335017");
		Recipeentity recipe1=new Recipeentity(date,2,"friedrice",li,"keep tossing veges", true,"5 persons");
		Recipeentity r1=recipeservice.addNewRecipe(recipe1);
		
		assertNotNull(r1);
	}
		@Test
		void testUpdateRecipe() {
			Ingredientsentity ig1=new Ingredientsentity("veges,oil,salt,chilli");
			List<Ingredientsentity> li=new ArrayList<>();
			li.add(ig1);
			LocalDateTime date =LocalDateTime.parse("2022-04-21T16:01:21.335017");
			Recipeentity recipe1=new Recipeentity(date,2,"vegetable pulao",li,"keep tossing veges", true,"5 persons");
			//Recipeentity r1=recipeservice.addNewRecipe(recipe1);
			reciperepository.save(recipe1);
		recipe1=new Recipeentity(date,2,"vegetables pulao",li,"keep tossing veges", true,"5 persons");
			//reciperepository.save(recipe1);
		Recipeentity r=recipeservice.updateRecipe(recipe1);
			assertEquals("vegetables pulao",r.getRecipeName());
			
		}
		@Test
		void testDeleteRecipe() {
			Ingredientsentity ig1=new Ingredientsentity("maggie masala,oil,water,salt,veges");
			List<Ingredientsentity> li=new ArrayList<>();
			li.add(ig1);
			LocalDateTime date =LocalDateTime.parse("2022-04-21T16:01:21.335017");
			Recipeentity rpc=new Recipeentity(date,3,"maggie",li,"pour everything in water and boil it", true,"3persons");
			//Recipeentity recipe2=new Recipeentity(date,4,"noodles",li,"pour everything in water and boil it",true,"5 persons");
			
		
		reciperepository.save(rpc);

			recipeservice.deleteRecipe(3);
			
			//assertThat((lr.size()).isGreaterThan(0));
			//assertEquals(,lr);
			List<Recipeentity> r1=(List<Recipeentity>)recipeservice.getAllRecipes();
			
			//assertEquals(false,r1.get(0).isVegetarian());
			assertNotNull(r1.get(0).getRecipeName());
			
		}
		@Test
		void testFindRecipe() {
			Ingredientsentity ig=new Ingredientsentity("popcornseeds");
			List<Ingredientsentity> lii=new ArrayList<>();
			lii.add(ig);
			LocalDateTime date =LocalDateTime.parse("2022-04-23T16:01:21.335017");
			Recipeentity rec1=new Recipeentity(date,5,"Popcorn",lii,"pour popcorn seeds in cooker and wait for 5 min",true,"4 persons");
			Recipeentity rec2=reciperepository.save(rec1);
			Optional<Recipeentity> rp=recipeservice.findRecipe(rec2.getRecipeId()); 
			
			assertEquals(rec2.getRecipeName(),rp.get().getRecipeName());
		}
		
		
}
