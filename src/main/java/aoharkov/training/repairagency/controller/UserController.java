package aoharkov.training.repairagency.controller;

import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private UserService userService;

    @GetMapping(value = {"/", "/login"})
    public String loginGet() {
        return "login";
    }

    @GetMapping("/register")
    public String registerGet(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(Model model, @Valid User user, BindingResult bindingResult) {
        userService.register(user);
        return "login";
    }

    @RequestMapping("/access-denied")
    public String denied() {
        return "error403";
    }


}
