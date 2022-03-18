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
    public User getSpecificUser (@PathVariable("id") long id){
        return userRepository.findById(id).get();
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
        return getSpecificUser(id).getCalculations();
    }

    @GetMapping("/users")
    public User getUsers(@RequestBody UserRequest userRequest){
        return userRequest.getUser();
    }
}
