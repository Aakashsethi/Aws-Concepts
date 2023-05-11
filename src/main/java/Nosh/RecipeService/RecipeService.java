package Nosh.RecipeService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import Nosh.Model.Recipe;
import Nosh.RecipeRepository.RecipeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Transactional
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Transactional(readOnly = true)
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    @Transactional
    public Recipe updateRecipe(Long id, Recipe recipe) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);

        if (optionalRecipe.isPresent()) {
            Recipe existingRecipe = optionalRecipe.get();

            existingRecipe.setName(recipe.getName());
            existingRecipe.setDescription(recipe.getDescription());
            existingRecipe.setIngredients(recipe.getIngredients());
            existingRecipe.setInstructions(recipe.getInstructions());

            return recipeRepository.save(existingRecipe);
        } else {
            return null;
        }
    }

    @Transactional
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

}
