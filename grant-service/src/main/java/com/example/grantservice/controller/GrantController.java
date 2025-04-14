package com.example.grantservice.controller;

import com.example.grantservice.model.Grant;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grants")
public class GrantController {

    private static final List<Grant> GRANTS = List.of(
            new Grant("1", "Startup Innovation Grant", 5000, "Technology"),
            new Grant("2", "Women in Tech", 4000, "Equality"),
            new Grant("3", "Green Future Fund", 10000, "Environment")
    );

    @GetMapping("/{id}")
    public Grant getGrantById(@PathVariable String id) {
        return GRANTS.stream()
                .filter(grant -> grant.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Grant not found"));
    }
}
