package guru.springframework.bootstrap;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;

@Component
public class DataLoader implements CommandLineRunner {

	private CategoryRepository categoryRepo;
	private UnitOfMeasureRepository unitOfMeasureRepo;
	private RecipeRepository recipeRepo;
	
	public DataLoader(CategoryRepository categoryRepo, UnitOfMeasureRepository unitOfMeasureRepo,
			RecipeRepository recipeRepo) {
		this.categoryRepo = categoryRepo;
		this.unitOfMeasureRepo = unitOfMeasureRepo;
		this.recipeRepo = recipeRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		guacamoleRecipe();
		spicyChickenRecipe();
	}

	private void guacamoleRecipe() {
		Set<Ingredient> ingredients = new HashSet<>();
		
		Ingredient ing1 = new Ingredient();
		ing1.setDescription("ripe avocados");
		ing1.setAmount(BigDecimal.valueOf(2L));
		ing1.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Units").get());
		ingredients.add(ing1);
		
		Ingredient ing2 = new Ingredient();
		ing2.setDescription("Kosher salt");
		ing2.setAmount(BigDecimal.valueOf(0.5));
		ing2.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Teaspoon").get());
		ingredients.add(ing2);
		
		Ingredient ing3 = new Ingredient();
		ing3.setDescription("fresh lime juice or lemon juice");
		ing3.setAmount(BigDecimal.valueOf(1.0));
		ing3.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Tablespoon").get());
		ingredients.add(ing3);
		
		Ingredient ing4 = new Ingredient();
		ing4.setDescription("minced red onion or thinly sliced green onion");
		ing4.setAmount(BigDecimal.valueOf(2.0));
		ing4.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Tablespoon").get());
		ingredients.add(ing4);
		
		Ingredient ing5 = new Ingredient();
		ing5.setDescription("serrano chiles, stems and seeds removed, minced");
		ing5.setAmount(BigDecimal.valueOf(2.0));
		ing5.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Units").get());
		ingredients.add(ing5);
		
		Ingredient ing6 = new Ingredient();
		ing6.setDescription("cilantro (leaves and tender stems), finely chopped");
		ing6.setAmount(BigDecimal.valueOf(2.0));
		ing6.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Tablespoon").get());
		ingredients.add(ing6);
		
		Ingredient ing7 = new Ingredient();
		ing7.setDescription("freshly grated black pepper");
		ing7.setAmount(BigDecimal.valueOf(1.0));
		ing7.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Dash").get());
		ingredients.add(ing7);
		
		
		Ingredient ing8 = new Ingredient();
		ing8.setDescription("ripe tomato, seeds and pulp removed, chopped");
		ing8.setAmount(BigDecimal.valueOf(0.5));
		ing8.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Units").get());
		ingredients.add(ing8);

		Set<Category> categories = new HashSet<>();
		categories.add(categoryRepo.findByDescription("Mexican").get());
		categories.add(categoryRepo.findByDescription("Fast Food").get());
		
		Notes notes = new Notes();
		notes.setRecipeNotes("1. Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of "
				+ "the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n"
				+ "2. Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n"
				+ "3. Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some "
				+ "balance to the richness of the avocado and will help delay the avocados from turning brown.\n"
				+ "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half "
				+ "of one chili pepper and add to the guacamole to your desired degree of hotness.\n" 
				+ "Remember that much of this is done to taste because of the variability in the fresh ingredients. "
				+ "Start with this recipe and adjust to your taste.\n"
				+ "4. Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. "
				+ "(The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n"
				+ "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");
		
		Recipe recipe = new Recipe();
		recipe.setDescription("Perfect Guacamole ");
		recipe.setCookTime(10);
		recipe.setDifficulty(Difficulty.EASY);
		recipe.setDirections("Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.");
		recipe.setPrepTime(10);
		recipe.setServings(4);
		recipe.setSource("Simply Recipes");
		recipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
		recipe.setIngredients(ingredients);
		recipe.setCategories(categories);
		recipe.setNotes(notes);
		
		ing1.setRecipe(recipe);
		ing2.setRecipe(recipe);
		ing3.setRecipe(recipe);
		ing4.setRecipe(recipe);
		ing5.setRecipe(recipe);
		ing6.setRecipe(recipe);
		ing7.setRecipe(recipe);
		ing8.setRecipe(recipe);
		
		notes.setRecipe(recipe);
		
		recipeRepo.save(recipe);
	}
	
	private void spicyChickenRecipe() {
		Set<Ingredient> ingredients = new HashSet<>();
		
		Ingredient ing1 = new Ingredient();
		ing1.setDescription("ancho chili powders");
		ing1.setAmount(BigDecimal.valueOf(2L));
		ing1.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Tablespoon").get());
		ingredients.add(ing1);
		
		Ingredient ing2 = new Ingredient();
		ing2.setDescription("dried oregano");
		ing2.setAmount(BigDecimal.valueOf(1.0));
		ing2.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Teaspoon").get());
		ingredients.add(ing2);
		
		Ingredient ing3 = new Ingredient();
		ing3.setDescription("dried cumin");
		ing3.setAmount(BigDecimal.valueOf(1.0));
		ing3.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Teaspoon").get());
		ingredients.add(ing3);
		
		Ingredient ing4 = new Ingredient();
		ing4.setDescription("sugar");
		ing4.setAmount(BigDecimal.valueOf(1.0));
		ing4.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Teaspoon").get());
		ingredients.add(ing4);
		
		Ingredient ing5 = new Ingredient();
		ing5.setDescription("salt");
		ing5.setAmount(BigDecimal.valueOf(1.0));
		ing5.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Teaspoon").get());
		ingredients.add(ing5);
		
		Ingredient ing6 = new Ingredient();
		ing6.setDescription("clove garlic, finely chopped");
		ing6.setAmount(BigDecimal.valueOf(1.0));
		ing6.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Units").get());
		ingredients.add(ing6);
		
		Ingredient ing7 = new Ingredient();
		ing7.setDescription("finely grated orange zest");
		ing7.setAmount(BigDecimal.valueOf(1.0));
		ing7.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Teaspoon").get());
		ingredients.add(ing7);
		
		
		Ingredient ing8 = new Ingredient();
		ing8.setDescription("fresh-squeezed orange juice");
		ing8.setAmount(BigDecimal.valueOf(3.0));
		ing8.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Tablespoon").get());
		ingredients.add(ing8);
		
		Ingredient ing9 = new Ingredient();
		ing9.setDescription("olive oil");
		ing9.setAmount(BigDecimal.valueOf(2.0));
		ing9.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Tablespoon").get());
		ingredients.add(ing9);
		
		Ingredient ing10 = new Ingredient();
		ing10.setDescription("skinless, boneless chicken thigh");
		ing10.setAmount(BigDecimal.valueOf(6.0));
		ing10.setUnitOfMeasure(unitOfMeasureRepo.findByDescription("Units").get());
		ingredients.add(ing10);

		Set<Category> categories = new HashSet<>();
		categories.add(categoryRepo.findByDescription("American").get());
		categories.add(categoryRepo.findByDescription("Fast Food").get());
		
		Notes notes = new Notes();
		notes.setRecipeNotes("1. Prepare a gas or charcoal grill for medium-high, direct heat\n"
				+ "2. Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. "
				+ "Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n"
				+ "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n"
				+ "3. Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat "
				+ "registers 165F. Transfer to a plate and rest for 5 minutes.\n"
				+ "4. Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. "
				+ "As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" 
				+ "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n"
				+ "5. Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");

		Recipe recipe = new Recipe();
		recipe.setDescription("Spicy Grilled Chicken Tacos");
		recipe.setCookTime(15);
		recipe.setDifficulty(Difficulty.MODERATE);
		recipe.setDirections("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online.");
		recipe.setPrepTime(20);
		recipe.setServings(6);
		recipe.setSource("Simply Recipes");
		recipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
		recipe.setIngredients(ingredients);
		recipe.setCategories(categories);
		recipe.setNotes(notes);
		
		ing1.setRecipe(recipe);
		ing2.setRecipe(recipe);
		ing3.setRecipe(recipe);
		ing4.setRecipe(recipe);
		ing5.setRecipe(recipe);
		ing6.setRecipe(recipe);
		ing7.setRecipe(recipe);
		ing8.setRecipe(recipe);
		ing9.setRecipe(recipe);
		ing10.setRecipe(recipe);
		
		notes.setRecipe(recipe);
		
		recipeRepo.save(recipe);
	}
	

}
