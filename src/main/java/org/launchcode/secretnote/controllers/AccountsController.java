package org.launchcode.secretnote.controllers;

import org.launchcode.secretnote.models.LoginFormDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("account")
public class AccountsController {

    @GetMapping("")
    public String displayEditForm(Model model){
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Edit Account");
        return "accounts/index";
    }

}
