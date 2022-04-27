package com.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.recipeentity.Ingredientsentity;

public interface Ingredientsrepository extends JpaRepository<Ingredientsentity,Integer>{

}
