package com.nixsolutions.controller.admin;

import com.nixsolutions.bean.User;
import com.nixsolutions.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    private static final Logger LOG = LogManager.getLogger(AdminController.class.getName());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, @RequestParam(value = "error", required = false) String error) {
        try {
            List<User> users = userService.getAllUsers();
            model.addAttribute("users", users);
            if (error != null) {
                model.addAttribute("error", error);
            }
        } catch (Exception e) {
            LOG.catching(e);
            model.addAttribute("error", e.getMessage());
            return "admin";
        }
        return "admin";
    }

    @RequestMapping(value = "/delete")
    public String deleteUser(@RequestParam("user_id") String userID, Model model) {
        try {
            userService.delete(Long.parseLong(userID));
            return "redirect:/admin";
        } catch (Exception e) {
            LOG.catching(e);
            model.addAttribute("error", "Can not delete user who has orders.");
            return "redirect:/admin";
        }
    }


    @RequestMapping(value = "/update_user", method = RequestMethod.GET)
    public ModelAndView viewUserUpdateForm(@RequestParam("user_id") String userID) {
        try{
            User user = userService.getUser(Long.parseLong(userID));
            return new ModelAndView("updateUser", "user", user);
        } catch (Exception e) {
            LOG.catching(e);
            throw LOG.throwing(new RuntimeException(e));
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user")User user, Model model) {
        try {
            userService.edit(user);
            return "admin";
        } catch (Exception e) {
            LOG.catching(e);
            model.addAttribute("error", e.getMessage());
            return "redirect:/admin";
        }
    }

}
