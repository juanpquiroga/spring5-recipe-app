package guru.springframework.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.RecipeServices;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {
	
	private CategoryRepository categoryRepo;
	private UnitOfMeasureRepository unitOfMeasureRepo;
	
	private RecipeServices recipeServices;
	
	@Autowired
    public IndexController(CategoryRepository categoryRepo, UnitOfMeasureRepository unitOfMeasureRepo,
    		RecipeServices recipeServices) {
		this.categoryRepo = categoryRepo;
		this.unitOfMeasureRepo = unitOfMeasureRepo;
		this.recipeServices = recipeServices;
	}

	@RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model ){
		Optional<Category> cat = categoryRepo.findByDescription("Italian");
		System.out.println(String.format("La categoria es: %s", cat.get().getId()));
		
		Optional<UnitOfMeasure> measure = unitOfMeasureRepo.findByDescription("Cup");
		System.out.println(String.format("La medida es: %s", measure.get().getId()));
		
		model.addAttribute("recipes",recipeServices.getRecipes());
        return "index";
    }
}
