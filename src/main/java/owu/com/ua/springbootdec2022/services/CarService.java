package owu.com.ua.springbootdec2022.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import owu.com.ua.springbootdec2022.Dao.CarDao;
import owu.com.ua.springbootdec2022.models.Car;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private final CarDao carDao;
    private CarDao userDao;

    public ResponseEntity<List<Car>> getAllMyCars (){
        return new ResponseEntity<>(carDao.findAll(), HttpStatus.ACCEPTED) ;
    }


    public Car saveNewCar(Car car){
        return carDao.save(car);
    }


    public Car findMyCarById(int id){

        return carDao.findById(id).get();

    }

    public ResponseEntity<List<Car>> DeleteMyCar (int id){

        carDao.deleteById(id);

        return new ResponseEntity<>(carDao.findAll(), HttpStatus.LOCKED) ;

    }


}
