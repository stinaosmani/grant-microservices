package com.example.grantservice.controller;

import com.example.grantservice.app.dto.GrantDto;
import com.example.grantservice.domain.port.GrantService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grants")
public class GrantController {

    private final GrantService grantService;

    public GrantController(GrantService grantService) {
        this.grantService = grantService;
    }

    @GetMapping("/{id}")
    public GrantDto getGrantById(@PathVariable String id) {
        return grantService.getGrantById(id);
    }
}
