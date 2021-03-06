package com.swm.datatracker.respositories;

import com.swm.datatracker.models.Status;
import com.swm.datatracker.models.User;
import com.swm.datatracker.models.WorkOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.lang.annotation.Native;

import java.util.List;

@Repository
public interface WorkOrderRepository extends CrudRepository<WorkOrder, Long> {
    List<WorkOrder> findAllByCategoryContainsOrDescriptionContainsOrCustomerContains (String string, String string2, String string3);

    @Query(nativeQuery = true,
            value = "SELECT * FROM mgmt_db.work_order wo WHERE wo.customer_id = 1?")

    List<WorkOrder> findAllByUser(Long id);

    List<WorkOrder> findAllById(long id);

    List<WorkOrder> findAllByEmployee(User user);

    List<WorkOrder> findAllByCustomer(User user);

    List<WorkOrder> findAllByStatus(Status status);

    List<WorkOrder> findAllByCustomerAndStatus(User user, Status status);

    List<WorkOrder> findAllByEmployeeAndStatus(User user, Status status);

    List<WorkOrder> findAllByDescriptionContainsOrNotesContains(String search1, String search2);

    List<WorkOrder> findAllByZipCode(long zip);

    List<WorkOrder> findAllByStreetNameContains(String search);
}
