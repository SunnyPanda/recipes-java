package recipes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
public class RecipesController {

    public static Long id = 0L;
    private final Map<Long, Recipe> recipes = new HashMap<>();

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id) {
        Recipe recipe = recipes.get(id);
        return recipe == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                              : new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PostMapping("/new")
    public Response saveRecipe(@RequestBody Recipe newRecipe) {
        Long newId = generateId();
        recipes.put(newId, newRecipe);
        return new Response(newId);
    }

    private Long generateId() {
        return ++id;
    }
}
