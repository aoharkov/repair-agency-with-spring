package aoharkov.training.repairagency.controller;

import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.service.UserService;
import aoharkov.training.repairagency.service.exception.EntityAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.register(user);
        } catch (EntityAlreadyExistException e) {
            bindingResult
                    .rejectValue("userEmail", "error.user",
                            "There is already a user registered with the user email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", user);
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }
}
