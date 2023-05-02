package org.example.spring.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final UserDAO userDAO;

    @Autowired
    public RegistrationController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userDAO.save(user);
        return "redirect:/login";
    }
}
