package com.recipe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.recipe.recipeentity.Recipeentity;
//import com.recipe.repository.Ingridientsrepository;
import com.recipe.repository.Reciperepository;

@Service//@Service annotation is used in service layer,it annotates the classes that perform service task.
@Transactional
public class Recipeservice {
	
	@Autowired//@Autowired annotation enables you to inject the object dependency implicitly.
	private Reciperepository reciperepository;
	
/*getAllRecipes is a method which returns the all the recipies from database
 *  as a list, it makes use of Reciperepository instance to findall the recipes from
 *  database
 */
	
	public List<Recipeentity> getAllRecipes(){
		List<Recipeentity> li=new ArrayList<Recipeentity>();
		reciperepository.findAll().forEach(li::add);
		return li;
	}
	
	
/*addNewRecipe is a method which is used to add the new recipedata into the database,it
 *  takes new recipe data as an input and saves it in the repository and returns
 *   the saved data, it makes use of Reciperepository instance to save the data into 
 *   database.
 */
	public Recipeentity addNewRecipe(@RequestBody Recipeentity rec) {
		return reciperepository.save(rec);
	}
	
	
/*updateRecipe is a method which is used to update the existing recipedata into the database,
 * it takes existing data as an input and after updating the data it is 
 * saved in the database and returns the updated data from database.
 */
	public Recipeentity updateRecipe(@RequestBody Recipeentity rec) {
		return reciperepository.save(rec);
	}
	
	
/*deleteRecipe is a method which is used to delete the data from database,it takes
 * recipeid as an input and deletes the recipe  with respect to the provided recipeid 
 * and returns the remaining data from the database, it makes use of Reciperepository instance
 *  to delete the recipe by id.
 * 
 */
	
	public void  deleteRecipe(@RequestBody int recipeid){
		reciperepository.deleteById(recipeid);
		//return (List<Recipeentity>)reciperepository.findAll();
	}

/*findRecipe is a method which is used to find the data with respect to the provided recipeid ,
 * so this method  takes recipeid as an input and finds the recipe of that particular id and 
 * returns it, it makes use of Reciperepository instance to find the recipe by its id.
 */
	public Optional<Recipeentity> findRecipe(@RequestBody int recipeid) {
		return reciperepository.findById(recipeid);
	}


	
}
