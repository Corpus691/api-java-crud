package com.roberto.proyect.springboot.app.springboot_crud.services;

import java.util.List;
import java.util.Optional;

import com.roberto.proyect.springboot.app.springboot_crud.entities.Empleado;

public interface  empleadoService {
    List<Empleado> findAll();

    Optional<Empleado> findById(Long IDUSER);

    Empleado save(Empleado NOMBRE);

    Optional <Empleado> delete(Empleado NOMBRE);
    
    //Optional<Empleado> update(Long IDUSER, Empleado NOMBRE);

    //Optional<Empleado> delete(Long IDUSER);

    //boolean existsBySku(String sku);
}
