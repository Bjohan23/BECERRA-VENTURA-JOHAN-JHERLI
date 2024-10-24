package com.cabrera.facturacion.almacen.service.impl;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.facturacion.almacen.entity.infractions;
import com.cabrera.facturacion.almacen.exception.GeneralException;
import com.cabrera.facturacion.almacen.exception.NoDataFoundException;
import com.cabrera.facturacion.almacen.exception.ValidateException;
import com.cabrera.facturacion.almacen.repository.InfraccionesRepository;
import com.cabrera.facturacion.almacen.service.IfractionsService;
import com.cabrera.facturacion.almacen.validator.InfraccionValidator;

public class infraccionesServiceImpl implements  IfractionsService {
    @Autowired
    public InfraccionesRepository repository;

    @Override
    @Transactional (readOnly = true)
    public List<infractions> findAll(Pageable page) {
        try {
            List<infractions> registros = repository.findAll(page).toList();
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error en el servidor");
        }
    }

    @Override
    public List <infractions> findAll() {
        try {
            List<infractions> registros = repository.findAll();
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error en el servidor");
        }
    }

    @Transactional (readOnly = true)
    public List<infractions> finByNombre(String nombre, Pageable page) {
        try {
            List<infractions> registros = repository.findByNombreContaining(nombre, page);
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error en el servidor");
        }
    }

    @Transactional
    @Override
    public infractions findById(int id) {
        try {
            infractions registro = repository.findById((long) id)
                    .orElseThrow(()-> new NoDataFoundException("No se encontro el registro"));
            return registro;
        } catch (ValidateException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error en el servidor");
        }
    }
    @Transactional
    @Override
    public infractions save(infractions infraccion) {
        try {
            InfraccionValidator.validate(infraccion);
            if(infraccion.getId() == null){
                infractions nuevo = repository.save(infraccion);
                return nuevo;
            }

            return repository.save(infraccion);
        } catch (ValidateException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error en el servidor");
        }
    }

    @Override
    public void delete(int id) {
        try {
            infractions registro = repository.findById(id).orELseThrow(() -> new NoDataFoundException("No se encontro el registro"));
            repository.delete(registro);
        } catch (ValidateException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error en el servidor");
        }
    }

}
