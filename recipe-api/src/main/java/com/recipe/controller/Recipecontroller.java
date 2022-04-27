package com.recipe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.recipeentity.Recipeentity;
import com.recipe.repository.Reciperepository;
import com.recipe.service.Recipeservice;

@RestController//@RestController annotation is used in order to simplify the creation of RESTful web services.
public class Recipecontroller{
	
@Autowired//@Autowired annotation enables you to inject the object dependency implicitly.
private Recipeservice recipeservice ;

@RequestMapping(value = "/recipes", method = RequestMethod.GET)
/*@GetMapping("/recipes")/*The @GetMapping annotated methods in the @Controller annotated 
classes handle the HTTP GET requests matched with given URI expression,it act as a 
shortcut for @RequestMapping(method = RequestMethod.GET)*/

/*getrecipies is a method which is used to retrieve the all recipes from database
 * it uses getallrecipies() method from Recipeservice class to retrieve the data.
 */
public List<Recipeentity> getrecipes(){
	return  recipeservice.getAllRecipes();
}

@GetMapping("/recipe/{recipeid}")/*The @GetMapping annotated methods in the @RestController annotated 
classes handle the HTTP GET requests matched with given URI expression,it act as a 
shortcut for @RequestMapping(method = RequestMethod.GET)*/

/*findRecipe is a method which is used to retrieve the recipedata with respect to provided recipeid,
 * it uses finbyrecipeno() method from Recipeservice class to retrieve the recipedata from database .
 @PathVariable used for accessing the values from the URI template.
 */
public Optional<Recipeentity> findRecipeById(@PathVariable int recipeid) {
	return recipeservice.findRecipe(recipeid);
}

@PostMapping("/newrecipe")/*The @PostMapping annotated methods in the @RestController annotated 
classes handle the HTTP POST requests matched with given URI expression,it act as a 
shortcut for @RequestMapping(method = RequestMethod.POST)*/

/*addRecipe is a method which is used to add the new recipedata into database,
 * it uses AddnewRecipe() method from Recipeservice class to save the recipedata into database
 *and returns the saved data .
 *The @RequestBody annotation is applicable to handler methods of Spring controllers. This annotation indicates 
 *that Spring should deserialize a request body into an object.
 */
 public Recipeentity addRecipe(@RequestBody Recipeentity rec) {
	return recipeservice.addNewRecipe(rec);
}

@PutMapping("/update")/*The @PutMapping annotated methods in the @RestController annotated 
classes handle the HTTP PUT requests matched with given URI expression,it act as a 
shortcut for @RequestMapping(method = RequestMethod.PUT)*/

/*update is a method which is used to update the existing recipedata,it uses
 * UpdateRecipe() method from Recipeservice class to update the recipedata into database
 *and returns the updated data .
 */
public Recipeentity update(@RequestBody Recipeentity rec) {
	return recipeservice.updateRecipe(rec);
}

@DeleteMapping("/removerecipe/{recipeid}")/*The @DeleteMapping annotated methods in the
 @RestController annotated classes handle the HTTP DELETE requests matched with given URI
  expression,it act as a shortcut for @RequestMapping(method = RequestMethod.DELETE)*/

/* deleteRecipeByIdis a method which is used to delete the recipedata from database with
 * respect to the provided recipeid and returns the remaining recipedata from database,
 * it uses deleteRecipe() method from Recipeservice class to delete recipedata and to
 * return the existing data from database.
 */
public void deleteRecipeById(@PathVariable int recipeid) {
	 recipeservice.deleteRecipe(recipeid);
}


}
