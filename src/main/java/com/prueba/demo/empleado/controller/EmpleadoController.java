package com.prueba.demo.empleado.controller;

import com.prueba.demo.empleado.dto.ResponseDTO;
import com.prueba.demo.empleado.model.Empleado;
import com.prueba.demo.empleado.service.EmpleadoService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.UUID;

/**
 * Controlador REST para la gestión de empleados. Proporciona los endpoints
 * necesarios para realizar operaciones CRUD sobre la entidad Empleado y está
 * documentado con Swagger.
 * 
 * @author
 */
@RestController
@RequestMapping("/api/empleados")
@Tag(name = "Empleados", description = "Operaciones relacionadas con empleados")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"})
public class EmpleadoController {

	private EmpleadoService empleadoService;

	/**
	 * Obtiene todos los empleados registrados.
	 * 
	 * @return Un objeto {@link ResponseDTO} que contiene la lista de empleados.
	 */
	@Operation(summary = "Obtener todos los empleados", description = "Devuelve una lista con todos los empleados registrados.")
	@GetMapping
	public ResponseDTO getAll() {
		return new ResponseDTO(UUID.randomUUID().toString(), 1, "Proceso Exitoso", empleadoService.getAllEmpleados());
	}

	/**
	 * Obtiene un empleado específico por su identificador único.
	 * 
	 * @param id Identificador único del empleado.
	 * @return Un objeto {@link ResponseDTO} que contiene el empleado solicitado o
	 *         un mensaje de error si no se encuentra.
	 */
	@Operation(summary = "Obtener empleado por ID", description = "Devuelve un empleado según el ID proporcionado.")
	@GetMapping("/{id}")
	public ResponseDTO getById(@PathVariable Long id) {
		Optional<Empleado> empleadoOptional = Optional.ofNullable(empleadoService.getEmpleadoById(id));

		return empleadoOptional
				.map(empleado -> new ResponseDTO(UUID.randomUUID().toString(), 1, "Proceso Exitoso", empleado))
				.orElseGet(() -> new ResponseDTO(UUID.randomUUID().toString(), 0, "Empleado no encontrado", null));
	}

	/**
	 * Guarda un nuevo empleado o actualiza uno existente.
	 * 
	 * @param empleado Objeto empleado a guardar o actualizar.
	 * @return Un objeto {@link ResponseDTO} que contiene el empleado guardado.
	 */
	@Operation(summary = "Guardar empleado", description = "Guarda un nuevo empleado o actualiza uno existente.")
	@PostMapping
	public ResponseDTO save(@RequestBody Empleado empleado) {
		if(empleado.getId() != null && empleado.getId() == 0) {
			empleado.setId(null);
		}
		return new ResponseDTO(UUID.randomUUID().toString(), 1, "Empleado guardado con éxito",
				empleadoService.saveEmpleado(empleado));
	}

	/**
	 * Elimina un empleado por su identificador único.
	 * 
	 * @param id Identificador único del empleado a eliminar.
	 * @return Un objeto {@link ResponseDTO} que contiene un mensaje de éxito
	 *         indicando que el empleado fue eliminado.
	 */
	@Operation(summary = "Eliminar empleado", description = "Elimina un empleado según el ID proporcionado.")
	@DeleteMapping("/{id}")
	public ResponseDTO delete(@PathVariable Long id) {
		empleadoService.deleteEmpleado(id);
		return new ResponseDTO(UUID.randomUUID().toString(), 1, "Empleado eliminado con éxito", null);
	}
	
	/**
	 * Actualiza un empleado existente.
	 * 
	 * @param id       Identificador del empleado a actualizar.
	 * @param empleado Objeto empleado con los datos actualizados.
	 * @return Un objeto {@link ResponseDTO} que contiene el empleado actualizado.
	 */
	@Operation(summary = "Actualizar empleado", description = "Actualiza un empleado existente.")
	@PutMapping("/{id}")
	public ResponseDTO update(@PathVariable Long id, @RequestBody Empleado empleado) {
	    if (id == null || id <= 0) {
	        throw new IllegalArgumentException("El ID del empleado es inválido");
	    }

	    // Verifica que el empleado existe antes de actualizar
	    Empleado existingEmpleado = empleadoService.getEmpleadoById(id);
	    if (existingEmpleado == null) {
	        throw new EntityNotFoundException("Empleado con ID " + id + " no encontrado");
	    }

	    // Asigna el ID al empleado recibido y actualiza
	    empleado.setId(id);
	    Empleado updatedEmpleado = empleadoService.saveEmpleado(empleado);

	    return new ResponseDTO(UUID.randomUUID().toString(), 1, "Empleado actualizado con éxito", updatedEmpleado);
	}

}
