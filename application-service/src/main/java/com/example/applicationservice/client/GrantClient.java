package com.example.applicationservice.client;

import com.example.applicationservice.model.Grant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "grant-client", url = "${grant.service.url}")
public interface GrantClient {
    @GetMapping("/grants/{id}")
    Grant getGrantById(@PathVariable String id);
}
