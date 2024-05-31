package owu.com.ua.springbootdec2022.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import owu.com.ua.springbootdec2022.CarDao.CarDao;
import owu.com.ua.springbootdec2022.models.Car;

import java.util.List;

@RestController
@AllArgsConstructor
//@RequestMapping(value = "/Cars")
public class CarController {

    private CarDao carDao;

@GetMapping("/cars")
   public ResponseEntity<List<Car>> getAllCars() {
    return new ResponseEntity<>(carDao.findAll(), HttpStatus.ACCEPTED);
}


@ResponseStatus(HttpStatus.CREATED)
@PostMapping("/cars")
    public Car addCar(@RequestBody Car car) {
    return carDao.save(car);
}


@GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable("id") int carId) {
    return carDao.findById(carId).get();
}


@DeleteMapping("/cars")
public List<Car> deleteAllCars(@RequestParam("id") int carId) {
    carDao.deleteById(carId);
    return carDao.findAll();

}










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
//get cars/power/{value} (знайти всі по потужності)
//get cars/producer/{value} (знайти всі по виробнику)