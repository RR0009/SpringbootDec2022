package owu.com.ua.springbootdec2022.CarDao;

import org.springframework.data.jpa.repository.JpaRepository;
import owu.com.ua.springbootdec2022.models.Car;

public interface CarDao extends JpaRepository<Car, Integer> {

}
