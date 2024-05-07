/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author joseluis
 */
public interface RepositoryPersona extends MongoRepository<Persona, String> {
    
}