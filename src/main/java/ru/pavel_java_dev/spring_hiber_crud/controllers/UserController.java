package ru.pavel_java_dev.spring_hiber_crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pavel_java_dev.spring_hiber_crud.models.User;
import ru.pavel_java_dev.spring_hiber_crud.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("users", userService.list());
        return "users/list";
    }

    @GetMapping("/{id}")
    public String userByID(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "users/user";
    }

    @GetMapping("/create")
    public String createForm(@ModelAttribute("user") User user) {
        return "users/create";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}