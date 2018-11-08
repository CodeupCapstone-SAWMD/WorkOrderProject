package com.swm.datatracker.services;

import com.swm.datatracker.models.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends CrudRepository <Inventory, Long> {


    List<Inventory> findInventoryByNameContains(String term);
    List<Inventory> findInventoryByNameContainsOrSizeContains(String term1, String term2);

//NOTE: Are we going to have enough items that require a search function
}
