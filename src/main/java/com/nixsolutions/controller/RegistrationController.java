package com.nixsolutions.controller;

import com.nixsolutions.bean.Role;
import com.nixsolutions.bean.User;
import com.nixsolutions.service.RoleService;
import com.nixsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add_user", method = RequestMethod.GET)
    public ModelAndView viewAddFrom() {
        return new ModelAndView("registration", "user", new User());
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user, Model model) {
        if (user.getFirstName().length() == 0 || user.getLastName().length() == 0 || user.getEmail().length() == 0
                || user.getPhoneNumber().length() == 0 || user.getPassword().length() == 0) {
            model.addAttribute("error", "Error. Fill in all the fields!");
            return "registration";
        } else {
            user.setKarma(0);
            Role role = roleService.getRoleByName("Guest");
            user.setRole(role);
            try {
                userService.add(user);
                model.addAttribute("msg", "You have successfully registered.");
                return "index";
            } catch (Exception e) {
                model.addAttribute("error", "Error. User with that email or phone number already registered!");
                return "registration";
            }
        }
    }
}
