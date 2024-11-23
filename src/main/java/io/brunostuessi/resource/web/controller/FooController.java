package io.brunostuessi.resource.web.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.brunostuessi.resource.persistence.model.Foo;
import io.brunostuessi.resource.service.IFooService;
import io.brunostuessi.resource.web.dto.FooDto;

@RestController
@RequestMapping(value = "/api/foos")
public class FooController {

    private IFooService fooService;


    public FooController(IFooService fooService) {
        this.fooService = fooService;
    }

    @GetMapping(value = "/{id}")
    public FooDto findOne(@PathVariable Long id) {
        final var entity = fooService.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToDto(entity);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody FooDto newFoo) {
        this.fooService.save(convertToEntity(newFoo));
    }

    @GetMapping
    public Collection<FooDto> findAll() {
        final var foos = this.fooService.findAll();
        var fooDtos = new ArrayList<FooDto>();
        foos.forEach(p -> fooDtos.add(convertToDto(p)));
        return fooDtos;
    }

    @PutMapping("/{id}")
    public FooDto updateFoo(@PathVariable("id") Long id, @RequestBody FooDto updatedFoo) {
        return this.convertToDto(this.fooService.save(convertToEntity(updatedFoo)));
    }

    protected FooDto convertToDto(Foo entity) {
        return new FooDto(entity.getId(), entity.getName());
    }

    protected Foo convertToEntity(FooDto dto) {
        final var foo = new Foo(dto.name());
        if (dto.id() != null) {
            foo.setId(dto.id());
        }
        return foo;
    }

}