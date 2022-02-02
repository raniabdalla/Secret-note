package org.launchcode.secretnote.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("settings")
public class SettingsController {

    @GetMapping
    public String displayNotes(Model model) {
        model.addAttribute("title", "Settings");

        return "settings";
    }
}
