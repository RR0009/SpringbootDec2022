package owu.com.ua.springbootdec2022.controllers;


import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import owu.com.ua.springbootdec2022.models.Customer;
import owu.com.ua.springbootdec2022.serivices.CustomerService;

@RestController
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;


    @PostMapping("/save")
    public void save (@RequestBody Customer customer) {

        customerService.save(customer);
    }
}
