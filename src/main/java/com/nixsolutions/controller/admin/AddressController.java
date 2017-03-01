package com.nixsolutions.controller.admin;

import com.nixsolutions.bean.Address;
import com.nixsolutions.bean.User;
import com.nixsolutions.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressController {

    private static final Logger LOG = LogManager.getLogger(AddressController.class.getName());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public String viewAddress(@RequestParam("user_id") String userID, Model model) {
        Address address;
        User user;
        try{
            user = userService.getUser(Long.parseLong(userID));
            address = user.getAddress();
            model.addAttribute("address", address);
            model.addAttribute("user", user);
            return "address";
        } catch (Exception e){
            LOG.catching(e);
            model.addAttribute("error", e.getMessage());
            return "redirect:/admin";
        }
    }
}
