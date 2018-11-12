package com.swm.datatracker.respositories;

import com.swm.datatracker.models.Status;
import com.swm.datatracker.models.WorkOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkOrderRepository extends CrudRepository<WorkOrder, Long> {
    List<WorkOrder> findAllByCategoryContainsOrDescriptionContainsOrCustomerContains (String string, String string2, String string3);
    List<WorkOrder> findAllByStatus(Status status);
}
