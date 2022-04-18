package com.study.springstudy2.controller;

import com.study.springstudy2.dto.request.UserCreateRequestDto;
import com.study.springstudy2.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @PostMapping
    public void createUser(@RequestBody UserCreateRequestDto dto){
        Long id = usersService.createUser(dto);
        System.out.println(id);
    }
}
