package owu.com.ua.springbootdec2022.controllers;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import owu.com.ua.springbootdec2022.UserDao.UserDao;
import owu.com.ua.springbootdec2022.models.User;
import owu.com.ua.springbootdec2022.models.Views;
import owu.com.ua.springbootdec2022.models.userDto.UserDto;
import owu.com.ua.springbootdec2022.services.UserService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
@Data
//@RequestMapping(value ="/users")
public class UserController {


//    private UserDao userDao;
    private UserService userService;


    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
//        List<UserDto> collect = userDao.findAll().stream().map(user -> new UserDto(user.getName())).collect(Collectors.toList());
//        return new ResponseEntity<>(collect, HttpStatus.ACCEPTED);

//        return userService.

                return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/users")
    public void createUser(@RequestBody UserDto userDto) {

//        String name = userDto.getName();
//        User user = new User(name);
//        return userDao.save(user);

        userService.saveUsers(userDto);
    }




    @GetMapping("/users/{id}")
    public User findUserById(@PathVariable("id") int Userid) {

        return userService.getUserById(Userid);


    }

    @DeleteMapping("/users")
    public List<User> deleteUser(@RequestParam("id") int userId) {
//       userDao.deleteById(userId);
//    return userDao.findAll();

       return  userService.DeleteUserById(userId);
   }




    @GetMapping("/users/level1")

    @JsonView(Views.Level1.class)
    public List<User> getAllUsersAccessByLevel1(){

        return userService.getUsersByAccesLevel();


    }



}