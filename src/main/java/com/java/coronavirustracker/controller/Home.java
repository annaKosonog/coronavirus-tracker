package com.java.coronavirustracker.controller;

import com.java.coronavirustracker.model.LocationStat;
import com.java.coronavirustracker.service.CoronavirusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Home {

    private CoronavirusService coronavirusService;

    public Home(CoronavirusService coronavirusService) {
        this.coronavirusService = coronavirusService;
    }

    @GetMapping("/")
    public String home(Model model) {
        final List<LocationStat> allStats = coronavirusService.getAllStats();
        final int totalReported= allStats.stream().mapToInt(LocationStat::getLatestCases).sum();
        final int totalNew = allStats.stream().mapToInt(stat-> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReported);
        model.addAttribute("totalNewCases", totalNew);
        return "home";
    }
}
