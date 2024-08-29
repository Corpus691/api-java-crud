package com.roberto.proyect.springboot.app.springboot_crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roberto.proyect.springboot.app.springboot_crud.entities.Empleado;
import com.roberto.proyect.springboot.app.springboot_crud.services.empleadoService;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private empleadoService service;


    @GetMapping
    public List<Empleado> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Empleado> empleadOptional = service.findById(id);
        if (empleadOptional.isPresent()) {
            return ResponseEntity.ok(empleadOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Empleado> create(@RequestBody Empleado empleado) {
                return ResponseEntity.status(HttpStatus.CREATED).body(service.save(empleado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> update(@PathVariable Long id, @RequestBody Empleado empleado) {
        empleado.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(empleado));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Empleado empleado = new Empleado();
        empleado.setId(id);
        Optional<Empleado> empleadOptional = service.delete(empleado);
        if (empleadOptional.isPresent()) {
            return ResponseEntity.ok(empleadOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
