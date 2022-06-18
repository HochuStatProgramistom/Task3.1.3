package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.domain.Role;
import ru.kata.spring.boot_security.demo.domain.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User savePerson(User user);

    User savePerson(User user, Set<Role> roles);

    Role saveRole(Role role);

    void addRoleToPerson(String username, String roleName);

    User getPerson(String username);

    List<User> getPersons();

    public User findById(Long id);

    public void deleteById(Long id);

    List<Role> getRoles();

    UserDetails loadUserByUsername(String email);
}
