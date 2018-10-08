package guru.springframework.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;

@Service
public class RecipeServicesImpl implements RecipeServices {
	private RecipeRepository recipeRepo;

	public RecipeServicesImpl(RecipeRepository recipeRepo) {
		this.recipeRepo = recipeRepo;
	}
	
	/* (non-Javadoc)
	 * @see guru.springframework.services.RecipeServices#getRecipes()
	 */
	@Override
	public Set<Recipe> getRecipes() {
		Set<Recipe> respuesta = new HashSet<>();
		//recipeRepo.findAll().forEach(recipe->respuesta.add(recipe));
		recipeRepo.findAll().iterator().forEachRemaining(respuesta::add);
		return respuesta;
	}
}
