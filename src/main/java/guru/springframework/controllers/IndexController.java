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
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jt on 6/1/17.
 */
@Slf4j
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
		log.info(">>>>>>>>>> IndexController Ingreso a getIndexPage");
		Optional<Category> cat = categoryRepo.findByDescription("Italian");
		log.debug(String.format("La categoria es: %s", cat.get().getId()));
		
		Optional<UnitOfMeasure> measure = unitOfMeasureRepo.findByDescription("Cup");
		log.debug(String.format("La medida es: %s", measure.get().getId()));
		
		model.addAttribute("recipes",recipeServices.getRecipes());
		log.error("Despues de recuperar recetas");
        return "index";
    }
}
