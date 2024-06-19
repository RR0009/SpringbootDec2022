package owu.com.ua.springbootdec2022.controllers;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import owu.com.ua.springbootdec2022.Dao.CarDao;
import owu.com.ua.springbootdec2022.Views.Views;
import owu.com.ua.springbootdec2022.models.Car;
import owu.com.ua.springbootdec2022.services.CarService;

import java.util.List;

@RestController
@AllArgsConstructor
//@RequestMapping(value = "/Cars")
public class CarController {

//    private CarDao carDao;
    private CarService carService;

    @GetMapping("/Cars")
//    @JsonView(Views.levelOne.class)
    public ResponseEntity<List<Car>> getAllCars (){
//        return new ResponseEntity<>(carDao.findAll(), HttpStatus.ACCEPTED);
        return carService.getAllMyCars();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/Cars")
    public Car addCar (@RequestBody Car car){

        return carService.saveNewCar(car);
//        return carDao.save(car);

    }

    @GetMapping("/Cars/{id}")
    public Car getCarById(@PathVariable("id") int CarId){
//        return carDao.findById(CarId).get();
        return carService.findMyCarById(CarId);
    }




    @DeleteMapping("/Cars")
    public ResponseEntity<List<Car>> deleteCarById(@RequestParam("id") int CarId){

        return carService.DeleteMyCar(CarId);

//        carDao.deleteById(CarId);
//        return carDao.findAll();
    }

//    @GetMapping("/Cars/{value}")
//    public Car getCarByValue(@PathVariable("value") String value){
//
//   return carDao.findBy(value);
//
//    }





}


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
