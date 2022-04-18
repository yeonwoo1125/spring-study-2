package com.study.springstudy2.controller;

import com.study.springstudy2.dto.request.UserCreateRequestDto;
import com.study.springstudy2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    private final UserService usersService;

    @PostMapping
    public void createUser(@RequestBody UserCreateRequestDto dto){
        Long id = usersService.createUser(dto);
        System.out.println(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        usersService.deleteUser(id);
    }
}
