package com.study.springstudy2.controller;

import com.study.springstudy2.dto.request.UserCreateRequestDto;
import com.study.springstudy2.dto.response.UserFindResponseDto;
import com.study.springstudy2.entity.User;
import com.study.springstudy2.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Api(tags = {"회원 관리 API"})
public class UserRestController {
    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody UserCreateRequestDto dto){
        Long id = userService.createUser(dto);
        System.out.println(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/{id}")
    public UserFindResponseDto findUser(@PathVariable Long id){
        return userService.findUser(id);
    }
}
