package com.cabrera.facturacion.almacen.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cabrera.facturacion.almacen.entity.infractions;
import org.springframework.transaction.annotation.Transactional;

public interface IfractionsService {
    public List<infractions> findAll(Pageable page);
    public List<infractions> findAll(  );

    @Transactional
    infractions findById(int id);

    @Transactional
    infractions save(infractions infraccion);

    void delete(int id);
}
