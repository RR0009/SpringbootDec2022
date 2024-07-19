package owu.com.ua.springbootdec2022.security;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import owu.com.ua.springbootdec2022.models.Customer;
import owu.com.ua.springbootdec2022.serivices.CustomerService;

import java.util.List;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@Data
public class SecurityConfig {



        private CustomerService customerService;


    @Bean
    public UserDetailsService userDetailsService() {

        System.out.println(userDetailsService());


        return username -> {
            System.out.println(username);

            Customer customer = customerService.findByUsername(username);

          User user = new User(
                  customer.getUsername(),
                  customer.getPassword(),
                  List.of(new SimpleGrantedAuthority(customer.getRole())));

            return user;

        };
    }

    @Bean
    @SneakyThrows
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) {
        httpSecurity.authorizeRequests(auth ->
                auth
                        .requestMatchers(HttpMethod.GET,"/admin").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.GET,"/user").hasAnyRole("USER","ADMIN")
//                        .requestMatchers(HttpMethod.POST,"/save").permitAll()
                        .anyRequest().permitAll()

        )
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);

        return httpSecurity.build();
    }


}
