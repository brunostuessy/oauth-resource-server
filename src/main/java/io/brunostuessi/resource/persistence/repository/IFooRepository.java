package io.brunostuessi.resource.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import io.brunostuessi.resource.persistence.model.Foo;

public interface IFooRepository extends PagingAndSortingRepository<Foo, Long>,
    CrudRepository<Foo, Long> {
}
