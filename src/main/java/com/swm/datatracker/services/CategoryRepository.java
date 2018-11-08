package com.swm.datatracker.services;

import com.swm.datatracker.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findCategoriesById(long id);
    List<Category> findCategoriesByNameContains(String term);
}
