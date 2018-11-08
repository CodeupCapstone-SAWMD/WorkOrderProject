package com.swm.datatracker.services;

import com.swm.datatracker.models.Status;
import com.swm.datatracker.respositories.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    private StatusRepository statusRepo;

    public StatusService(StatusRepository statusRepo) {
        this.statusRepo = statusRepo;
    }
    //------------------------------- METHODS TO BE USED IN CONTROLLER -------------------------------\\

    public Iterable<Status> all(){
        return statusRepo.findAll();
    }

    //--------------------- UPDATES ---------------------\\

    //CREATES A NEW INVENTORY OBJECT (ROW) IN THE DATABASE
    public Status create(Status stat){
        return statusRepo.save(stat);
    }

    //EDITS THE INVENTORY OBJECT (ROW) IN THE DATABASE
    public Status edit(Status stat){
        return statusRepo.save(stat);
    }

    //DELETES THE INVENTORY OBJECT (ROW) OUT OF THE DATABASE
    public void delete(Status stat){
        statusRepo.delete(stat);
    }


    //--------------------- SEARCHES ---------------------\\

    //SEARCHES DATABASE FOR INVENTORY BASED ON NAME ONLY
    public List<Status> searchStatusById(long id){
        return statusRepo.findStatusById(id);
    }

    //SEARCHES DATABASE FOR INVENTORY BASED ON NAME OR SIZE
    public List<Status> searchStatusByName(String term){
        return statusRepo.findStatusByNameContains(term);
    }



}
