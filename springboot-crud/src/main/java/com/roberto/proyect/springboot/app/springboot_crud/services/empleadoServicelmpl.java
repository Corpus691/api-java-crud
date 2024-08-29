package com.roberto.proyect.springboot.app.springboot_crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roberto.proyect.springboot.app.springboot_crud.entities.Empleado;
import com.roberto.proyect.springboot.app.springboot_crud.repositories.empleadoRepository;

@Service
public class empleadoServicelmpl implements empleadoService{

    @Autowired
    private empleadoRepository repository;
    @Transactional(readOnly=true)
    @Override
    public List<Empleado> findAll() {
       
        return (List<Empleado>) repository.findAll();
    }
    
    @Override
    @Transactional(readOnly=true)
    public Optional<Empleado> findById(Long IDUSER) {
        
        return repository.findById(IDUSER);
    }


    @Override
    @Transactional
    public Empleado save(Empleado NOMBRE) {
      
        return repository.save(NOMBRE);
    }

    @Transactional
    @Override
    public Optional <Empleado> delete(Empleado NOMBRE) {
        Optional <Empleado> empleadoOptional = repository.findById(NOMBRE.getId());
        empleadoOptional.ifPresent(empleadoDb -> {
        repository.delete(empleadoDb);
        });
        return empleadoOptional;
    }
    

}
