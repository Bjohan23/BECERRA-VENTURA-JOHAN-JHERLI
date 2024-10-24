package com.cabrera.facturacion.almacen.converter;

import org.springframework.stereotype.Component;

import com.cabrera.facturacion.almacen.dto.InfractionsDto;
import com.cabrera.facturacion.almacen.entity.infractions;

@Component
public class infracciones extends AbstractConverter<infractions, InfractionsDto>  {
    @Override
    public InfractionsDto fromEntity(infractions entity) {
        if (entity == null) return null;
        return InfractionsDto.builder()
                .id(entity.getId())
                .licensePlate(entity.getLicensePlate())
                .description(entity.getDescription())
                .build();
    }
    @Override
    public infractions fromDTO(InfractionsDto dto) {
        if (dto == null) return null;
        return infractions.builder()
                .id(dto.getId())
                .licensePlate(dto.getLicensePlate())
                .description(dto.getDescription())
                .build();
    }
}
