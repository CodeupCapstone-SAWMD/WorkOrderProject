package com.swm.datatracker.respositories;

import com.swm.datatracker.models.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends CrudRepository <Status, Long> {

    Status findStatusById(long id);
    List<Status> findStatusByNameContains(String term);


}
