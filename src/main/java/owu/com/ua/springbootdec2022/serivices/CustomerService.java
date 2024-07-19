package owu.com.ua.springbootdec2022.serivices;

import owu.com.ua.springbootdec2022.models.Customer;

public interface CustomerService {

     void save(Customer customer);


     Customer findByUsername(String username);
}
