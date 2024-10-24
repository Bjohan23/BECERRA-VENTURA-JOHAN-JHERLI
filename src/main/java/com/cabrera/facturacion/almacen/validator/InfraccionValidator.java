package com.cabrera.facturacion.almacen.validator;
import com.cabrera.facturacion.almacen.entity.infractions;
import com.cabrera.facturacion.almacen.exception.ValidateException;

public class InfraccionValidator {
    public static void validate(infractions registro) {
        if (registro.getLicensePlate() == null || registro.getLicensePlate().trim().isEmpty()) {
            throw new ValidateException("El nombre de la infraccion es requerido");
        }
        if (registro.getLicensePlate().length()>70) {
            throw new ValidateException("El nombre de la infraccion no debe de tener mas de 70 caracteres");

        }
    }
}
