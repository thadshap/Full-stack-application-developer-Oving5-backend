package stud.ntnu.Oving5backend.Oving5backend.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import stud.ntnu.Oving5backend.Oving5backend.entity.LoginRequest;
import stud.ntnu.Oving5backend.Oving5backend.entity.LoginResponse;

@RestController
@RequestMapping(value = "/login")
@EnableAutoConfiguration
@CrossOrigin
public class LoginController {

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public LoginResponse doLogin(final @RequestBody LoginRequest loginRequest){
        LOGGER.info("Logging in..." + loginRequest.getUsername());
        if(loginRequest.getUsername().equalsIgnoreCase("Bruker")
                && loginRequest.getPassword().equalsIgnoreCase("bruker")) {
            return new LoginResponse("Success");
        }
        return new LoginResponse("Fail");
    }

}
