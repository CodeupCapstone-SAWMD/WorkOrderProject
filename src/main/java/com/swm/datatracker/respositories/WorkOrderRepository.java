package com.swm.datatracker.respositories;

import com.swm.datatracker.models.User;
import com.swm.datatracker.models.WorkOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface WorkOrderRepository extends CrudRepository<WorkOrder, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM mgmt_db.work_order wo WHERE wo.customer_id = 1?")
    List<WorkOrder> findAllByUser(Long id);

    List<WorkOrder> findAllByCustomer(User user);

}
