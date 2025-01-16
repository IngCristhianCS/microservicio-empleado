package com.prueba.demo.empleado.repository;

import com.prueba.demo.empleado.model.Empleado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la gestión de empleados en la base de datos.
 * Extiende JpaRepository para proporcionar las operaciones CRUD básicas.
 * 
 * @author CCASTILLO
 */
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	List<Empleado> findByEstatus(int estatus);
}
