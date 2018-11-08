package com.swm.datatracker.services;

import com.swm.datatracker.models.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends CrudRepository <Status, Long> {

    List<Status> findStatusById(long id);
    List<Status> findStatusByDescriptionContains(String term);


}
