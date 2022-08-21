package recipes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recipe")
public class RecipesController {

    private Recipe recipe;

    @GetMapping
    public Recipe getRecipe() {
        return recipe;
    }

    @PostMapping
    public void saveRecipe(@RequestBody Recipe newRecipe) {
        recipe = newRecipe;
    }
}
