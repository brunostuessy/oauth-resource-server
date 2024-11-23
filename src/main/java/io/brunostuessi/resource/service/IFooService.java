package io.brunostuessi.resource.service;

import java.util.Optional;

import io.brunostuessi.resource.persistence.model.Foo;


public interface IFooService {
    Optional<Foo> findById(Long id);

    Foo save(Foo foo);
    
    Iterable<Foo> findAll();

}
