/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author joseluis
 */ 
@RestController
@RequestMapping("/url")
public class ControllerPersona {
    @Autowired
    private RepositoryPersona repositorypersona;
    @GetMapping()
    public List<Persona> list() {
        return repositorypersona.findAll();
    }
    
    @GetMapping("/{id}")
    public Persona get(@PathVariable String id) {
             Optional<Persona> optPersona = repositorypersona.findById(id);
         return optPersona.orElse(null);
    }
    
    @PutMapping("/{id}")
    public Persona put(@PathVariable String id, @RequestBody Persona per) {
       Optional<Persona> optionalPersona = repositorypersona.findById(id);
            if (optionalPersona.isPresent()) {
                Persona persona = optionalPersona.get();
                persona = optionalPersona.get();
                persona.setNombre(per.getNombre());
                persona.setDireccion(per.getDireccion());
                persona.setTelefono(per.getTelefono());
                return repositorypersona.save(persona);
            } else {
                return null;
            }
    }
    
    @PostMapping
    public Persona post(@RequestBody Persona persona) {
           return repositorypersona.save(persona);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repositorypersona.deleteById(id);
    }
}