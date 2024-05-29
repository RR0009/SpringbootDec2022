package owu.com.ua.springbootdec2022.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import owu.com.ua.springbootdec2022.models.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
