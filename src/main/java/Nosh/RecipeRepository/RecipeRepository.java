package Nosh.RecipeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import Nosh.Model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    // You can add custom query methods here

}

