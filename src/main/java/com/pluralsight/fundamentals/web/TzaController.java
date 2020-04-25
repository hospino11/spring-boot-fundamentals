package com.pluralsight.fundamentals.web;

import com.pluralsight.fundamentals.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TzaController {

    private final ApplicationService applicationService;

    @GetMapping("applications")
    public String getApplications(Model model) {
        model.addAttribute("applications", applicationService.listApplications());
        return "applications";
    }
}
