package com.example.grantservice.app.service;

import com.example.grantservice.app.dto.GrantDto;
import com.example.grantservice.domain.model.Grant;
import com.example.grantservice.domain.port.GrantService;
import com.example.grantservice.infrastructure.mapper.GrantMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GrantServiceImpl implements GrantService {

    private final GrantMapper grantMapper;

    public GrantServiceImpl(GrantMapper grantMapper) {
        this.grantMapper = grantMapper;
    }

    private static final List<Grant> GRANTS = List.of(
            new Grant("1", "Startup Innovation Grant", 5000, "Technology"),
            new Grant("2", "Women in Tech", 4000, "Equality"),
            new Grant("3", "Green Future Fund", 10000, "Environment")
    );

    @Override
    public GrantDto getGrantById(String id) {
        Grant grant = GRANTS.stream()
                .filter(g -> g.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Grant with ID " + id + " not found"));

        return grantMapper.toDto(grant);
    }
}
