package ru.maltsev.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.maltsev.myproject.config.jwt.JwtUtils;

@RestController
public class MyController {

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/api/auth/home")
    public String show(){
        return "home";
    }

    @PostMapping("/home/post")
    public String postShow(@RequestBody String info){
        return info;
    }

}