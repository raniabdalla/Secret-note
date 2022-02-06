package org.launchcode.secretnote.controllers;

import org.launchcode.secretnote.data.UserRepository;
import org.launchcode.secretnote.models.LoginFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("accounts")
public class AccountsController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public String displayEditForm(Model model){
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Edit Account");
        return "accounts/index";
    }

    @GetMapping("delete")
    public String displayDeleteAccountForm(Model model) {
        model.addAttribute("title", "Delete Accounts");
        model.addAttribute("users", userRepository.findAll());
        return "accounts/delete";
    }

    @PostMapping("delete")
    public String processDeleteAccountForm(@RequestParam(required = false) int[] userIds) {

        if (userIds != null) {
            for (int id : userIds) {
                userRepository.deleteById(id);
            }
        }

        return "redirect:/login";
    }
}
