package com.cabrera.facturacion.almacen.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cabrera.facturacion.almacen.converter.infracciones;
import com.cabrera.facturacion.almacen.dto.InfractionsDto;
import com.cabrera.facturacion.almacen.entity.infractions;
import com.cabrera.facturacion.almacen.service.IfractionsService;
import com.cabrera.facturacion.almacen.util.WrapperResponse;

@RestController
@RequestMapping("/v1/infractions")
public class InfractionsController {
    @Autowired
    private IfractionsService service;
    @Autowired
    private infracciones converter;

    @GetMapping
    public ResponseEntity<List<InfractionsDto>> findAll(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
            ){
        Pageable page = PageRequest.of(pageNumber, pageSize);

        List<InfractionsDto> infracciones = converter.fromEntity(service.findAll());
        return new WrapperResponse("success",true,infracciones).createResponse(HttpStatus.OK);
    }
}
