package ru.kata.spring.boot_security.demo.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/api/user")
    public String getUser(Model model, Principal principal) {
        model.addAttribute("user", userService.getPerson(principal.getName()));
        return "user";
    }
}
