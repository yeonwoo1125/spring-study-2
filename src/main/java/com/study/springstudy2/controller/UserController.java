package com.study.springstudy2.controller;

import com.study.springstudy2.dto.request.UserCreateRequestDto;

import com.study.springstudy2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public String homePage(Model m){
        m.addAttribute("user", new UserCreateRequestDto());
        return "JoinUser";
    }

    @GetMapping("/users")
    public String getUsers(Model m){
        m.addAttribute("users", userService.findAllUsers());

        return "Result";
    }

    @PostMapping("/users")
    public String addUsers(@ModelAttribute UserCreateRequestDto dto, Model m){
        userService.createUser(dto);
        m.addAttribute("users",userService.findAllUsers());

        return "Result";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);

        return "redirect:/users";
    }
    @GetMapping("/deleteAll")
    public String deleteAllUser(){
        userService.deleteAllUsers();
        return "redirect:/users";
    }
}
