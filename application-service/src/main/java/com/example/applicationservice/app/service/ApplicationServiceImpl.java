package com.example.applicationservice.app.service;

import com.example.applicationservice.infrastructure.client.GrantClient;
import com.example.applicationservice.app.dto.GrantDto;
import com.example.applicationservice.domain.port.ApplicationService;
import com.example.applicationservice.infrastructure.mapper.GrantMapper;
import com.example.applicationservice.domain.model.Grant;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final GrantClient grantClient;
    private final GrantMapper grantMapper;

    public ApplicationServiceImpl(GrantClient grantClient, GrantMapper grantMapper) {
        this.grantClient = grantClient;
        this.grantMapper = grantMapper;
    }

    @Override
    public String applyForGrant(String grantId) {
        Grant grant = grantClient.getGrantById(grantId);
        GrantDto dto = grantMapper.toDto(grant);

        return "Application submitted for: " + dto.getTitle() +
                " (" + dto.getCategory() + "), Amount: €" + dto.getAmount();
    }
}
