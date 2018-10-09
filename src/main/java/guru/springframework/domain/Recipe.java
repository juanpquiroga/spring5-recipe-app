package guru.springframework.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.BatchSize;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by jt on 6/13/17.
 */
@Entity
@Getter
@Setter 
@ToString(exclude= {"notes","ingredients","categories"})
@EqualsAndHashCode(exclude= {"notes","ingredients","categories"})
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;  

    @Lob
    private Byte[] image;

    @OneToOne(fetch=FetchType.EAGER)
//    @JoinColumn(name="note_id")
    private Notes notes;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="recipe",fetch=FetchType.LAZY)
    private Set<Ingredient> ingredients = new HashSet<>();
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="RECIPE_CATEGORY",
    	joinColumns=@JoinColumn(name="recipe_id"),
    	inverseJoinColumns=@JoinColumn(name="category_id"))
    @BatchSize(size = 10)
    private Set<Category> categories = new HashSet<>();

    public void setNotes(Notes notes) {
    	System.out.println("notas");
        this.notes = notes;
        //notes.setRecipe(this);
    }

	public Recipe addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
		ingredient.setRecipe(this);
		return this;
	}
	
	public Recipe addCategory(Category category) {
		this.categories.add(category);
		return this;
	}
}
