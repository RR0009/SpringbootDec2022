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
import owu.com.ua.springbootdec2022.Views.Views;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @NotBlank(message = "name is strictly required")
    @Size(min = 2,message = "not less than 2 chars Dude!")
    @Size(max = 17,message = "amount must be less than 17 chars Pal!")
    @JsonView(Views.levelMain.class)
    private String model;
    @JsonView({Views.levelOne.class,Views.levelMain.class})
    private String producer;
    @JsonView({Views.levelOne.class,Views.levelMain.class})
    private int power;

}

//
//Створити модель
//Car
//        id
//model
//        producer
//power
//
//реалізувати запити
//get /cars
//get /cars/{id}
//post /cars
//delete /cars/{id}
//get cars/power/{value} (знайти всі по потужності) ()
//get cars/producer/{value} (знайти всі по виробнику)
