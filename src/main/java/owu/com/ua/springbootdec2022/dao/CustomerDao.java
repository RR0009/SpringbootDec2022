package owu.com.ua.springbootdec2022.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import owu.com.ua.springbootdec2022.models.Customer;

public interface CustomerDao extends JpaRepository<Customer,Integer> {

    Customer findByUsername(String username);
}
