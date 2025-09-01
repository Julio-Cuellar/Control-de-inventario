package com.jcode.userservice.controller;

import com.jcode.userservice.dto.RegisterRequest;
import com.jcode.userservice.dto.UserDTO;
import com.jcode.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")

@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody RegisterRequest request){
        UserDTO userDTO = userService.register(request);
        return ResponseEntity.ok(userDTO);
    }

}
