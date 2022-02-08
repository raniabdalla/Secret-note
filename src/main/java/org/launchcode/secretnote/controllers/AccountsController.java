package org.launchcode.secretnote.controllers;

import org.launchcode.secretnote.data.UserRepository;
import org.launchcode.secretnote.models.LoginFormDTO;
import org.launchcode.secretnote.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

    @GetMapping("username")
    public String displayEditUsernameForm(Model model){
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Edit Username");
        return "accounts/username";
    }

    @PostMapping("username")
    public String processEditUsernameForm(@RequestParam(value="newUsername") String newUsername,
                                          @ModelAttribute @Valid LoginFormDTO loginFormDTO,
                                          Errors errors, HttpServletRequest request,
                                          Model model) {
        /**the processEditUsernameForm is not working if I activate this if block, I need to figure out the reason*/
        /*if (errors.hasErrors()) {
            model.addAttribute("title", "Edit Username");
            return "accounts/username";
        }*/

        User existingUser = userRepository.findByUsername(loginFormDTO.getUsername());

        if (existingUser == null) {
            errors.rejectValue("username", "username.invalid", "The given username does not exist");
            model.addAttribute("title", "Edit Username");
            return "accounts/username";
        }

        existingUser.setUsername(newUsername);
        userRepository.save(existingUser);

        return "redirect:/login";
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
