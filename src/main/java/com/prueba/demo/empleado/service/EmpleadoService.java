package com.prueba.demo.empleado.service;

import com.prueba.demo.empleado.model.Empleado;
import com.prueba.demo.empleado.repository.EmpleadoRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para la gestión de empleados.
 * Proporciona los métodos para realizar las operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre la entidad Empleado.
 * 
 * @author 
 */
@Service
@AllArgsConstructor
public class EmpleadoService {

    private EmpleadoRepository repository;

    /**
     * Obtiene todos los empleados.
     * 
     * @return Lista de empleados disponibles en la base de datos.
     */
    public List<Empleado> getAllEmpleados() {
        return repository.findByEstatus(1);
    }

    /**
     * Obtiene un empleado específico por su identificador.
     * 
     * @param id Identificador único del empleado.
     * @return El empleado correspondiente al ID, o {@code null} si no se encuentra.
     */
    public Empleado getEmpleadoById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + id));
    }

    /**
     * Guarda un empleado en la base de datos.
     * Si el empleado ya existe, se actualiza su información.
     * 
     * @param empleado Objeto empleado a guardar o actualizar.
     * @return El empleado guardado con su ID asignado.
     */
    public Empleado saveEmpleado(Empleado empleado) {
        return repository.save(empleado);
    }

    /**
     * Elimina un empleado de la base de datos.
     * 
     * @param id Identificador único del empleado a eliminar.
     */
    public void deleteEmpleado(Long id) {
    	Empleado empleado = getEmpleadoById(id);
    	empleado.setEstatus(0);
    	repository.save(empleado);
    }
}
