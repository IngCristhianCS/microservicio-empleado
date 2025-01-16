package com.prueba.demo.empleado.dto;

import lombok.*;

/**
 * Clase para estructurar la respuesta estándar de los microservicios.
 * Incluye un identificador único, código de estado, mensaje y datos.
 * 
 * @author CCASTILLO
 */
@Data
@AllArgsConstructor
public class ResponseDTO {

    private String uuid;
    private int statusCode;
    private String message;
    private Object info;
}
