package owu.com.ua.springbootdec2022.models;


import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Level1.class)
    private int id;

    @NotBlank(message  = "name is strictly required")
    @Size(min =3,message = "minimum 3 chars")
    @Size(max =255,message = "name is too long kid")
    @JsonView({Views.Level1.class,Views.NoLevel.class})
    private String name;

    public User(String name) {
        this.name = name;
    }
}
