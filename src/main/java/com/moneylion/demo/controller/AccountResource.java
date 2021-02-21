package com.moneylion.demo.controller;

import com.moneylion.demo.controller.vm.ResponseDto;
import com.moneylion.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountResource {

    private final Logger log = LoggerFactory.getLogger(AccountResource.class);
    private UserService userService;

    public AccountResource(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/test-server")
    public String testServer(){
        return "Server is up";
    }

    @GetMapping("/feature")
    public ResponseEntity<ResponseDto> checkAccess(@RequestParam(name = "email") String email,
                                                   @RequestParam(name = "featureName") String featureName){

        Boolean canAccess = userService.checkFeatureAccess(email, featureName);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCanAccess(canAccess);

        return ResponseEntity.ok(responseDto);


    }

}
