package com.swm.datatracker.services;


import com.swm.datatracker.models.Inventory;
import com.swm.datatracker.respositories.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private InventoryRepository inventoryRepo;

    public InventoryService(InventoryRepository inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }




//------------------------------- METHODS TO BE USED IN CONTROLLER -------------------------------\\



//FINDS ALL ITEMS IN THE DATABASE
    public Iterable<Inventory> all(){
        return inventoryRepo.findAll();
    }

    public Inventory findOne(long id){
        return inventoryRepo.findOne(id);
    }

//--------------------- UPDATES ---------------------\\

//CREATES A NEW INVENTORY OBJECT (ROW) IN THE DATABASE
    public Inventory create(Inventory item){
        return inventoryRepo.save(item);
    }

//EDITS THE INVENTORY OBJECT (ROW) IN THE DATABASE
    public Inventory edit(Inventory item){
        return inventoryRepo.save(item);
    }

//DELETES THE INVENTORY OBJECT (ROW) OUT OF THE DATABASE
    public void delete(long id){
        inventoryRepo.delete(id);
    }



//--------------------- SEARCHES ---------------------\\

//SEARCHES DATABASE FOR INVENTORY BASED ON NAME ONLY
    public List<Inventory> searchDBName(String term){
        return inventoryRepo.findInventoryByNameContains(term);
    }

//SEARCHES DATABASE FOR INVENTORY BASED ON NAME OR SIZE
    public List<Inventory> searchDBNameOrSize(String term){
        return inventoryRepo.findInventoryByNameContainsOrSizeContains(term, term);
    }

















}
