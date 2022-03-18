package stud.ntnu.Oving5backend.Oving5backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stud.ntnu.Oving5backend.Oving5backend.dto.EquationsRequest;
import stud.ntnu.Oving5backend.Oving5backend.dto.UserRequest;
import stud.ntnu.Oving5backend.Oving5backend.entity.Calculation;
import stud.ntnu.Oving5backend.Oving5backend.entity.User;
import stud.ntnu.Oving5backend.Oving5backend.repository.CalculationRepository;
import stud.ntnu.Oving5backend.Oving5backend.repository.UserRepository;
import stud.ntnu.Oving5backend.Oving5backend.service.CalculationService;

import java.util.List;
import java.util.Optional;

@RestController
public class RegisterController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CalculationRepository calculationRepository;
    @Autowired
    private CalculationService calculationService;

    @PostMapping("/registerUser")
    public User registerUser(@RequestBody UserRequest request){
        return userRepository.save(request.getUser());
    }

    @GetMapping("/registerUser/{id}")
    public Optional<User> getSpecificUser (@PathVariable("id") long id){
        return userRepository.findById(id);
    }

    @PostMapping("/saveCalculationsToAUser/{id}")
    public void saveCalculationsToAUser(@RequestBody EquationsRequest equationsRequest, @PathVariable("id") long id){
        Calculation newExpression = new Calculation();
        newExpression.setEquation(equationsRequest.getEquation());
        System.out.println(equationsRequest.getEquation());
        String answer = calculationService.getAnswer(equationsRequest.getEquation());
        newExpression.setAnswer(Double.parseDouble(answer));
        calculationRepository.insertWithQuery(newExpression, id);
    }

    @GetMapping("/registerUser/equations/{id}")
    public List<Calculation> getCalculationsToAUser(@PathVariable("id") long id){
        return getSpecificUser(id).get().getCalculations();
    }

    @GetMapping("/users")
    public User getUsers(@RequestBody UserRequest userRequest){
        return userRequest.getUser();
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