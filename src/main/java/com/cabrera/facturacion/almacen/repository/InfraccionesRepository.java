package com.cabrera.facturacion.almacen.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabrera.facturacion.almacen.entity.infractions;

import java.util.List;
@Repository

public interface InfraccionesRepository extends JpaRepository<infractions, Long> {
    List<infractions> findByLicensePlateContaining(String license_plate, Pageable page);
}