package owu.com.ua.springbootdec2022.serivices;


import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import owu.com.ua.springbootdec2022.dao.CustomerDao;
import owu.com.ua.springbootdec2022.models.Customer;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    public CustomerDao customerDao;
    private PasswordEncoder passwordEncoder;


    @Override
    public void save(Customer customer) {
        String password = customer.getPassword();
        String encode = passwordEncoder.encode(password);
        customer.setPassword(encode);


        customerDao.save(customer);



    }

    @Override
    public Customer findByUsername(String username) {
        return customerDao.findByUsername(username);
    }
}
