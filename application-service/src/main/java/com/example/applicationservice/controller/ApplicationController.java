package com.example.applicationservice.controller;

import com.example.applicationservice.client.GrantClient;
import com.example.applicationservice.model.Grant;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apply")
public class ApplicationController {

    private final GrantClient grantClient;

    public ApplicationController(GrantClient grantClient) {
        this.grantClient = grantClient;
    }

    @GetMapping("/{grantId}")
    public String applyForGrant(@PathVariable String grantId) {
        Grant grant = grantClient.getGrantById(grantId);
        return "✅ Application submitted for: " + grant.getTitle() +
                " (" + grant.getCategory() + "), Amount: €" + grant.getAmount();
    }
}
