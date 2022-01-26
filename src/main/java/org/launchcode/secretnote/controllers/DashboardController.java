package org.launchcode.secretnote.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
    /**
     * Main functionality page - dashboard to view and edit notes
     *
     */
    @RequestMapping("dashboard")
    public String index(Model model)
    {
        model.addAttribute("title", "Secret Note Dashboard");
        return "dashboard";
    }
}
