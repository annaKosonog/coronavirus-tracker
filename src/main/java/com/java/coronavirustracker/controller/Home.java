package com.java.coronavirustracker.controller;

import com.java.coronavirustracker.service.CoronavirusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    private CoronavirusService coronavirusService;

    public Home(CoronavirusService coronavirusService) {
        this.coronavirusService = coronavirusService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("locationStats", coronavirusService.getAllStats());
        return "home";
    }
}
