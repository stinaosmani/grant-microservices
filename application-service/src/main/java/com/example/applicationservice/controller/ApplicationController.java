package com.example.applicationservice.controller;

import com.example.applicationservice.domain.port.ApplicationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apply")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/{grantId}")
    public String applyForGrant(@PathVariable String grantId) {
        return applicationService.applyForGrant(grantId);
    }
}
