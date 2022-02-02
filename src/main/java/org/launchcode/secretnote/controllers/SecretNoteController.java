package org.launchcode.secretnote.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecretNoteController {
    /**
     * Greet visitors on the main page.
     *
     */
    @RequestMapping("")
    public String index(Model model)
    {
        model.addAttribute("title", "Welcome to Secret Note");
        return "index";
    }

    /*
     * Display all stored notes
     *
     */



//    @RequestMapping("dashboard")
//    public String index(Model model)
//    {
//        model.addAttribute("title", "Welcome back!");
//        return "dashboard";
//    }
}
