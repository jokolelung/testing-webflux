package com.testing.testingwebflux.controller;

import com.testing.testingwebflux.model.dto.UserDto;
import com.testing.testingwebflux.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @CrossOrigin()
    @GetMapping(value = "/users", produces = "application/json")
    public Flux<UserDto> get(
            @RequestParam("pageNum") int pageNum,
            @RequestParam("pageSize") int pageSize

    ) {
        log.info("Fetch all users.");
        return this.userService.getUsers(pageNum, pageSize);
    }

}


