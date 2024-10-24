package com.cabrera.facturacion.almacen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfractionsDto {
    private Long id;
    private String licensePlate;
    private String description;
    private BigDecimal amount;
    private Date createdAt;
    private Date updatedAt;
}
