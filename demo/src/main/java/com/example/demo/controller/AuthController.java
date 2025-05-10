package com.example.demo.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // This matches login.html
    }


    @GetMapping("/generate")
@ResponseBody
public String generateHash(@RequestParam String raw) {
    return new BCryptPasswordEncoder().encode(raw);
}

}
