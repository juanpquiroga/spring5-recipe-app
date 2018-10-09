package guru.springframework.domain;

import javax.persistence.*;

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
@ToString(exclude= {"recipe"})
@EqualsAndHashCode(exclude= {"recipe"})
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy="notes")
    private Recipe recipe;

    @Lob
    private String recipeNotes;
}
