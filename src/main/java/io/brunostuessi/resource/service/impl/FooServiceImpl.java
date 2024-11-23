package io.brunostuessi.resource.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import io.brunostuessi.resource.persistence.model.Foo;
import io.brunostuessi.resource.persistence.repository.IFooRepository;
import io.brunostuessi.resource.service.IFooService;

@Service
public class FooServiceImpl implements IFooService {

    private final IFooRepository fooRepository;

    public FooServiceImpl(final IFooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    @Override
    public Optional<Foo> findById(Long id) {
        return fooRepository.findById(id);
    }

    @Override
    public Foo save(Foo foo) {
        return fooRepository.save(foo);
    }

    @Override
    public Iterable<Foo> findAll() {
        return fooRepository.findAll();
    }
}
