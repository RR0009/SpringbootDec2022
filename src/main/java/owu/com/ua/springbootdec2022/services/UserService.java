package owu.com.ua.springbootdec2022.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import owu.com.ua.springbootdec2022.UserDao.UserDao;
import owu.com.ua.springbootdec2022.models.User;
import owu.com.ua.springbootdec2022.models.userDto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserDao userDao;

    public ResponseEntity<List<UserDto>> getAllUsers(){

        List<UserDto> collect = userDao.findAll().stream().map(user -> new UserDto(user.getName())).collect(Collectors.toList());
        return new ResponseEntity<>(collect, HttpStatus.ACCEPTED);

    }

    public void saveUsers(UserDto userDto){

      String name = userDto.getName();
       User user = new User(name);

       if(user.getId() < 0){
           throw new RuntimeException("id!!!!!!!");

       }
       userDao.save(user);


    }

    public User getUserById (int id){

        return userDao.findById(id).get();


    }

    public List<User> DeleteUserById (int id){
        userDao.deleteById(id);
        return userDao.findAll();

    }


    public List<User> getUsersByAccesLevel (){

        return userDao.findAll();


    }



}
