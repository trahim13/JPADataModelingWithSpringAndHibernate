package org.trahim.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.trahim.spring.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String s);
}
