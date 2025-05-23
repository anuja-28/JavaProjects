package com.example.demo.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.dto.RegistrationDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.DeleteStatus;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", repo.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("user", new User()); // lowercase 'user' for consistency
        return "add_user";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute User user) {
          if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
             System.out.println("Password is null or empty.");
        throw new IllegalArgumentException("Password cannot be null or empty");
        
    }

        UserEntity entity = new UserEntity();
        entity.setEmail(user.getEmail());
        entity.setName(user.getName());
        entity.setPassword(passwordEncoder.encode(user.getPassword())); // Make sure password is not null
        entity.setUserDeleteStatus(DeleteStatus.active);
        repo.save(entity); 
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        UserEntity user = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute User user) {
        UserEntity entity = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));

        entity.setEmail(user.getEmail());
        entity.setName(user.getName());

        if (user.getPassword() != null && !user.getPassword().isBlank()) {
            entity.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        repo.save(entity);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/";
    }


@PostMapping("/regformSub")
public String handleForm(
    @ModelAttribute("regDto") @Valid RegistrationDTO dto,
    BindingResult result,
    Model model
) {
    // Custom validation: check if passwords match
    if (dto.getUser_pwd() != null && dto.getConfirmPwd() != null &&
        !dto.getUser_pwd().equals(dto.getConfirmPwd())) {


 logger.info("===== APPLICATION STARTED =====");

        result.rejectValue("confirmPwd", "error.confirmPwd", "Passwords do not match");
       
    }

    // Check for validation errors
    if (result.hasErrors()) {
        return "regForm"; // Redisplay the form with validation errors
    }

    // Map DTO to entity and save
    UserEntity entity = new UserEntity();
    entity.setName(dto.getName());
    entity.setEmail(dto.getEmail());
    entity.setPassword(passwordEncoder.encode(dto.getUser_pwd()));
    entity.setUserDeleteStatus(DeleteStatus.active);

    repo.save(entity);
logger.info("This is an info log ===> {}", entity);
     return "redirect:/";
}




}
