package com.recipe.repository;




import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.recipe.recipeentity.Recipeentity;

public interface Reciperepository extends JpaRepository<Recipeentity,Integer>{


	

}
