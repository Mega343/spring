package com.nixsolutions.controller.admin;

import com.nixsolutions.bean.Document;
import com.nixsolutions.bean.DocumentType;
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
public class DocumentController {

    private static final Logger LOG = LogManager.getLogger(DocumentController.class.getName());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/document", method = RequestMethod.GET)
    public String viewDocument(@RequestParam("user_id") String userID, Model model) {
        Document document;
        DocumentType documentType;
        User user;
        try{
            user = userService.getUser(Long.parseLong(userID));
            document = user.getDocument();
            documentType = document.getDocumentType();
            model.addAttribute("document", document);
            model.addAttribute("docType", documentType);
            model.addAttribute("user", user);
            return "document";
        } catch (Exception e){
            LOG.catching(e);
            model.addAttribute("error", e.getMessage());
            return "redirect:/admin";
        }
    }
}
