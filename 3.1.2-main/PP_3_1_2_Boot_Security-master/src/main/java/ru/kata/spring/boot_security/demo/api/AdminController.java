package ru.kata.spring.boot_security.demo.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.domain.Role;
import ru.kata.spring.boot_security.demo.domain.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;

    @GetMapping("/api/admin")
    public String readUsers(Model model, Principal principal) {
        model.addAttribute("admin", userService.getPerson(principal.getName()));
        model.addAttribute("users", userService.getPersons());
        model.addAttribute("roles", userService.getRoles());
        return "admin";
    }

    @PostMapping("/api/admin/user-create")
    public String createUser(User user, @RequestParam("roles") Set<Role> roles) {
        userService.savePerson(user, roles);
        return "redirect:/api/admin";
    }

    @PostMapping("/api/admin/user-update")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam("roles") Set<Role> roles) {
        userService.savePerson(user, roles);
        return "redirect:/api/admin";
    }

    @GetMapping("/api/admin/user-delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/api/admin";
    }
}
