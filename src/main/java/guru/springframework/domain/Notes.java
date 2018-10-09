package guru.springframework.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by jt on 6/13/17.
 */
@Entity
@Data
/*@Getter
@Setter 
@ToString
@EqualsAndHashCode*/
//@ToString(exclude= {"recipe"})
//@EqualsAndHashCode(exclude= {"recipe"})
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@OneToOne
    //@JoinColumn(name="recipe_id")
    @NotNull
    private Recipe recipe;
*/
    //@Lob
    //@Length(max=2000)
    private String recipeNotes;
}
