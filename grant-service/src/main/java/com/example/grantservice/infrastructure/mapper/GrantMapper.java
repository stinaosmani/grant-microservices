package com.example.grantservice.infrastructure.mapper;

import com.example.grantservice.app.dto.GrantDto;
import com.example.grantservice.domain.model.Grant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GrantMapper {
    GrantDto toDto(Grant grant);

    Grant toModel(GrantDto dto);
}
