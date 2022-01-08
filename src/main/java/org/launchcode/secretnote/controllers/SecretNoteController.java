package org.launchcode.secretnote.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecretNoteController {
    /**
     * Greet visitors on the main page.
     *
     */
    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello, Secret Notetaker!";
    }
}
