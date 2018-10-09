package guru.springframework.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

	@Query("from Recipe r join fetch r.notes ")
	Iterable<Recipe> findEagerly();
}
