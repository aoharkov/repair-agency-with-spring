package aoharkov.training.repairagency.controller;

import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AdminController {
    private UserService userService;

    @GetMapping("/admin/users/all")
    /*public String usersAll(Model model, @RequestParam("page") String page,
                           @RequestParam("rowCount") String rowCount) {
        int pageNum = Integer.parseInt(page);
        int itemsPerPage = Integer.parseInt(rowCount);
        */
    public String usersAll(Model model) {
        int pageNum = 1;
        int itemsPerPage = 22;
        Page<User> pageOfUsers = userService.findAllUsers(pageNum - 1, itemsPerPage);
        List<User> users = pageOfUsers.getContent();
        model.addAttribute("users", users);
        return "users.html";
    }

}
