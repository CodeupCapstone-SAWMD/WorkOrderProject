package com.swm.datatracker.respositories;

import com.swm.datatracker.models.WorkOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderRepository extends CrudRepository<WorkOrder, Long> {

}
