package com.study.springstudy2.controller;

import com.study.springstudy2.dto.request.UserCreateRequestDto;

import com.study.springstudy2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public String homePage(Model m){
        m.addAttribute("user", new UserCreateRequestDto());
        return "JoinUser";
    }

}
