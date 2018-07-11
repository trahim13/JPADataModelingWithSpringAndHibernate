package org.trahim.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.trahim.spring.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String s);
}
