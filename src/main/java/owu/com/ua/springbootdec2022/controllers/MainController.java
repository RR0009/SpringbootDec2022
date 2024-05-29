package owu.com.ua.springbootdec2022.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import owu.com.ua.springbootdec2022.dao.UserDao;
import owu.com.ua.springbootdec2022.models.User;

import java.util.List;


//    @RequestMapping(value = "/users")
@RestController
@AllArgsConstructor
public class MainController {

    private UserDao userDao;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping ("/users")
    public void saveUser(@RequestBody User user) {
        userDao.save(user);

    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDao.findAll();

    }


    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") int Userid){
        User user = userDao.findById(Userid).get();
        return user;

    }



    @DeleteMapping("/users")
    public List<User> deleteUser(@RequestParam("id") int userId) {
        userDao.deleteById(userId);
        return userDao.findAll();
    }





}


