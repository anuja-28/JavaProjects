package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository repo;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", repo.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("User", new User());
        return "add_user";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("User") User User) {
        repo.save(User);
        return "redirect:/";
    }
@GetMapping("/edit/{id}")
public String edit(@PathVariable Long id, Model model) {
    UserEntity user = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
    model.addAttribute("user", user);
    return "edit_user"; // ✅ match the actual HTML filename (case sensitive)
}

@PostMapping("/update/{id}")
public String update(@PathVariable Long id, @ModelAttribute("user") User user) {
    user.setId(id); // important to ensure it updates instead of creating new
    repo.save(user);
    return "redirect:/"; // redirect back to user list
}

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}
