package com.swm.datatracker.services;

import com.swm.datatracker.models.WorkOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderRepo extends CrudRepository<WorkOrder, Long> {

}
