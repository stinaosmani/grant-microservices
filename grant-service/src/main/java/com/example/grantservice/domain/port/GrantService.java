package com.example.grantservice.domain.port;

import com.example.grantservice.app.dto.GrantDto;

public interface GrantService {
    GrantDto getGrantById(String id);
}
