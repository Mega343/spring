package com.nixsolutions.controller;

import org.springframework.stereotype.Controller;
<<<<<<< HEAD
=======
import org.springframework.ui.Model;
>>>>>>> 30f0efedd90235c4420a7fc5ff4644a2ea8420cb
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

<<<<<<< HEAD
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
=======
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
>>>>>>> 30f0efedd90235c4420a7fc5ff4644a2ea8420cb
        return "index";
    }
}
