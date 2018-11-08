package com.swm.datatracker.services;

import com.swm.datatracker.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

//------------------------------- METHODS TO BE USED IN CONTROLLER -------------------------------\\

    public Iterable<Category> all(){
        return categoryRepo.findAll();
    }

    //--------------------- UPDATES ---------------------\\

    //CREATES A NEW INVENTORY OBJECT (ROW) IN THE DATABASE
    public Category create(Category cat){
        return categoryRepo.save(cat);
    }

    //EDITS THE INVENTORY OBJECT (ROW) IN THE DATABASE
    public Category edit(Category cat){
        return categoryRepo.save(cat);
    }

    //DELETES THE INVENTORY OBJECT (ROW) OUT OF THE DATABASE
    public void delete(Category cat){
        categoryRepo.delete(cat);
    }


    //--------------------- SEARCHES ---------------------\\

    //SEARCHES DATABASE FOR INVENTORY BASED ON NAME ONLY
    public List<Category> searchCategories(long id){
        return categoryRepo.findCategoriesById(id);
    }

    //SEARCHES DATABASE FOR INVENTORY BASED ON NAME OR SIZE
    public List<Category> searchCategoriesByName(String term){
        return categoryRepo.findCategoriesByNameContains(term);
    }



}
