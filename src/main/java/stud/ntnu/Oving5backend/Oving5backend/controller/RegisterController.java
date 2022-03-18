package stud.ntnu.Oving5backend.Oving5backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import stud.ntnu.Oving5backend.Oving5backend.dto.UserRequest;
import stud.ntnu.Oving5backend.Oving5backend.entity.User;
import stud.ntnu.Oving5backend.Oving5backend.repository.UserRepository;

@RestController
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/registerUser")
    public User registerUser(@RequestBody UserRequest request){
        return userRepository.save(request.getUser());
    }
}

/*
package stud.ntnu.Oving5backend.Oving5backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import stud.ntnu.Oving5backend.Oving5backend.dto.OrderRequest;
import stud.ntnu.Oving5backend.Oving5backend.dto.OrderResponse;
import stud.ntnu.Oving5backend.Oving5backend.entity.Customer;
import stud.ntnu.Oving5backend.Oving5backend.repository.CustomerRepository;
import stud.ntnu.Oving5backend.Oving5backend.repository.ProductRepository;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
    }

}
 */