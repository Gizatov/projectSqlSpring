package org.example.spring.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private final UserDAO userDAO;

    @Autowired
    public LoginController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "register/login";
    }

    @PostMapping("/login")
    public String authenticateUser(@ModelAttribute("user") User user, HttpSession session) {
        User existingUser = userDAO.findByEmail(user.getEmail());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("user", existingUser);
            return "redirect:/cities";
        } else {
            return "register/login";
        }
    }
}
