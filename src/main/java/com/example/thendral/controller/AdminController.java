package com.example.thendral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.thendral.repository.UserRepository;
import com.example.thendral.model.User;
import com.example.thendral.model.MoodEntry;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin/users")
    public String viewAllUsers(Model model) {
    List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "admin-users";
    }

    @PostMapping("/admin/block")
    public String blockUser(@RequestParam Long userId) {
    Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setEnabled(false); // User will be blocked
            userRepository.save(user);
        }
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {
    List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        // TODO: Add last updated entries for each user
        return "admin-dashboard";
    }
}
