package com.prueba.demo.empleado.controller.handler;

import com.prueba.demo.empleado.dto.ResponseDTO;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.UUID;

/**
 * Controlador global para el manejo de excepciones en la aplicación. Captura y
 * responde de forma estándar a todos los errores.
 * 
 * @author CCASTILLO
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Maneja todas las excepciones genéricas no controladas.
	 * 
	 * @param ex      Excepción capturada.
	 * @param request Detalles de la solicitud en la que ocurrió la excepción.
	 * @return Respuesta estándar con detalles del error.
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> handleGlobalException(Exception ex, WebRequest request) {
		ResponseDTO response = new ResponseDTO(UUID.randomUUID().toString(), 0,
				"Error interno del servidor: " + ex.getMessage(), null);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Maneja excepciones personalizadas.
	 * 
	 * @param ex      Excepción personalizada capturada.
	 * @param request Detalles de la solicitud en la que ocurrió la excepción.
	 * @return Respuesta estándar con detalles del error.
	 */
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ResponseDTO> handleRuntimeException(RuntimeException ex, WebRequest request) {
		ResponseDTO response = new ResponseDTO(UUID.randomUUID().toString(), 0, "Error: " + ex.getMessage(), null);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Maneja excepciones lanzadas por argumentos inválidos.
	 *
	 * @param ex Excepción capturada.
	 * @return Respuesta estándar con detalles del error.
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ResponseDTO> handleIllegalArgumentException(IllegalArgumentException ex) {
		ResponseDTO response = new ResponseDTO(UUID.randomUUID().toString(), 0, "Error: " + ex.getMessage(), null);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Maneja excepciones lanzadas cuando una entidad no se encuentra.
	 *
	 * @param ex Excepción capturada.
	 * @return Respuesta estándar con detalles del error.
	 */
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ResponseDTO> handleEntityNotFoundException(EntityNotFoundException ex) {
		ResponseDTO response = new ResponseDTO(UUID.randomUUID().toString(), 0, "Error: " + ex.getMessage(), null);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
