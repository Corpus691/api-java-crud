package com.roberto.proyect.springboot.app.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.roberto.proyect.springboot.app.springboot_crud.entities.Empleado;

public interface empleadoRepository extends CrudRepository <Empleado, Long> {

}
