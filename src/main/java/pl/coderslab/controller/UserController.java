package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.List;

@Controller
@RequestMapping("admin/permission")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String showAllUsers(Model model) {
        List<User> users = userService.showAll();
        model.addAttribute("users", users);
        return "userAll";
    }

    @GetMapping("/add")
    String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "userFormAdd";
    }

    @PostMapping("/add")
    public String addUser(@Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "userFormAdd";
        }
        userService.add(user);
        return "redirect: all";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        User editUser = userService.showById(id).orElseThrow();
        model.addAttribute("editUser", editUser);
        return "userEdit";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("editUser")
                           @Valid User editUser, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "userEdit";
        }
        userService.add(editUser);
        return "redirect: all";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect: /admin/permission/all";
    }


}
