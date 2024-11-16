package com.baeldung.resource.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.baeldung.resource.persistence.model.Foo;

public interface IFooRepository extends PagingAndSortingRepository<Foo, Long>,
    CrudRepository<Foo, Long> {
}
