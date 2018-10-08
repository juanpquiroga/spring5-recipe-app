package guru.springframework.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
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
		Ingredient ing1 = new Ingredient("ripe avocados", BigDecimal.valueOf(2L), getUOM("Units"));
		Ingredient ing2 = new Ingredient("Kosher salt", BigDecimal.valueOf(0.5), getUOM("Teaspoon"));
		Ingredient ing3 = new Ingredient("fresh lime juice or lemon juice", BigDecimal.valueOf(1.0),
				getUOM("Tablespoon"));
		Ingredient ing4 = new Ingredient("minced red onion or thinly sliced green onion", BigDecimal.valueOf(2.0),
				getUOM("Tablespoon"));
		Ingredient ing5 = new Ingredient("serrano chiles, stems and seeds removed, minced", BigDecimal.valueOf(2.0),
				getUOM("Units"));
		Ingredient ing6 = new Ingredient("cilantro (leaves and tender stems), finely chopped", BigDecimal.valueOf(2.0),
				getUOM("Tablespoon"));
		Ingredient ing7 = new Ingredient("freshly grated black pepper", BigDecimal.valueOf(1.0), getUOM("Dash"));
		Ingredient ing8 = new Ingredient("ripe tomato, seeds and pulp removed, chopped", BigDecimal.valueOf(0.5),
				getUOM("Units"));

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
		recipe.setDirections(
				"Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.");
		recipe.setPrepTime(10);
		recipe.setServings(4);
		recipe.setSource("Simply Recipes");
		recipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
		recipe.setNotes(notes);

		recipe.addCategory(getCategory("Mexican")).addCategory(getCategory("Fast Food"));

		recipe.addIngredient(ing1).addIngredient(ing2).addIngredient(ing3).addIngredient(ing4).addIngredient(ing5)
				.addIngredient(ing6).addIngredient(ing7).addIngredient(ing8);

		recipeRepo.save(recipe);
	}

	private UnitOfMeasure getUOM(String desc) {
		return unitOfMeasureRepo.findByDescription(desc).get();
	}

	private Category getCategory(String desc) {
		return categoryRepo.findByDescription(desc).get();
	}

	private void spicyChickenRecipe() {
		Ingredient ing1 = new Ingredient("ancho chili powders", BigDecimal.valueOf(2L), getUOM("Tablespoon"));
		Ingredient ing2 = new Ingredient("dried oregano", BigDecimal.valueOf(1.0), getUOM("Teaspoon"));
		Ingredient ing3 = new Ingredient("dried cumin", BigDecimal.valueOf(1.0), getUOM("Teaspoon"));
		Ingredient ing4 = new Ingredient("sugar", BigDecimal.valueOf(1.0), getUOM("Teaspoon"));
		Ingredient ing5 = new Ingredient("salt", BigDecimal.valueOf(1.0), getUOM("Teaspoon"));
		Ingredient ing6 = new Ingredient("clove garlic, finely chopped", BigDecimal.valueOf(1.0), getUOM("Units"));
		Ingredient ing7 = new Ingredient("finely grated orange zest", BigDecimal.valueOf(1.0), getUOM("Teaspoon"));
		Ingredient ing8 = new Ingredient("fresh-squeezed orange juice", BigDecimal.valueOf(3.0), getUOM("Tablespoon"));
		Ingredient ing9 = new Ingredient("olive oil", BigDecimal.valueOf(2.0), getUOM("Tablespoon"));
		Ingredient ing10 = new Ingredient("skinless, boneless chicken thigh", BigDecimal.valueOf(6.0), getUOM("Units"));

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
		recipe.setDirections(
				"Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online.");
		recipe.setPrepTime(20);
		recipe.setServings(6);
		recipe.setSource("Simply Recipes");
		recipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
		recipe.setNotes(notes);

		recipe.addIngredient(ing1).addIngredient(ing2).addIngredient(ing3).addIngredient(ing4).addIngredient(ing5)
				.addIngredient(ing6).addIngredient(ing7).addIngredient(ing8).addIngredient(ing9).addIngredient(ing10);
		recipe.addCategory(getCategory("American")).addCategory(getCategory("Fast Food"));

		recipeRepo.save(recipe);
	}

}
