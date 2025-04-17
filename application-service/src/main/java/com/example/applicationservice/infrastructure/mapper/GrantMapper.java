package com.example.applicationservice.infrastructure.mapper;

import com.example.applicationservice.app.dto.GrantDto;
import com.example.applicationservice.domain.model.Grant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GrantMapper {
    GrantDto toDto(Grant grant);

    Grant toModel(GrantDto dto);
}
