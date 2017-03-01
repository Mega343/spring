package com.nixsolutions.controller.admin;

import com.nixsolutions.bean.User;
import com.nixsolutions.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    private static final Logger LOG = LogManager.getLogger(AdminController.class.getName());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        try {
            List<User> users = userService.getAllUsers();
            model.addAttribute("users", users);
        } catch (Exception e) {
            LOG.catching(e);
            throw LOG.throwing(new RuntimeException(e));
        }
        return "admin";
    }

    @RequestMapping(value = "/delete/{user_id}")
    public String deleteUser(@PathVariable("user_id") Long userID, Model model) {
        try {
            userService.delete(userID);
            return "admin";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Can not delete user who has orders.");
            return "admin";
        } catch (Exception e) {
            LOG.catching(e);
            throw LOG.throwing(new RuntimeException(e));
        }
    }


    @RequestMapping(value = "/update_user/{user_id}", method = RequestMethod.GET)
    public ModelAndView viewUserUpdateForm(@PathVariable("user_id") Long id) {
        try{
            User user = userService.getUser(id);
            return new ModelAndView("updateUser", "user", user);
        } catch (Exception e) {
            LOG.catching(e);
            throw LOG.throwing(new RuntimeException(e));
        }
    }

    @RequestMapping(value = "/update_user", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user")User user) {
        try {
            userService.edit(user);
            return "/admin";
        } catch (Exception e) {
            LOG.catching(e);
            throw LOG.throwing(new RuntimeException(e));
        }
    }

}
