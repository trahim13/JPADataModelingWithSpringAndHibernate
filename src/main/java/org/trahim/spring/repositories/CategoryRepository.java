package org.trahim.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.trahim.spring.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
