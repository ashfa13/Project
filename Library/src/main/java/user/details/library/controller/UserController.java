package user.details.library.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import user.details.library.model.User;
import user.details.library.service.UserService;

import java.sql.SQLOutput;
import java.util.List;


@Controller
    @RequestMapping("/")
    public class UserController {

        @Autowired
        private UserService userService;
        @GetMapping("/")
    public String viewHomePage(Model model) {
            List<User> users= userService.listAll();
            model.addAttribute("listuser", users);
            System.out.println("Get / ");
            return "index";
        }


        @GetMapping("new")
    public String add(Model model){
            model.addAttribute("user", new User());
            return "new";

        }
        @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user){
            userService.save(user);
            return "redirect:/";
        }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditUserPage(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("new");
        User user = userService.get(id); // Assuming there is a method to get a user by ID in your service
        mav.addObject("user", user);
        return mav;
    }
        @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
            userService.delete(id);
            return "redirect:/";
        }

}

