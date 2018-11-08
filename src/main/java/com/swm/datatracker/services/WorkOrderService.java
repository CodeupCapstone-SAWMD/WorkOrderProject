package com.swm.datatracker.services;

import com.swm.datatracker.models.WorkOrder;
import org.springframework.stereotype.Service;
import com.swm.datatracker.respositories.WorkOrderRepository;

@Service
public class WorkOrderService {

    private WorkOrderRepository workOrderRepo;

    public WorkOrderService(WorkOrderRepository workOrderRepo){
        this.workOrderRepo = workOrderRepo;
    }

    public Iterable<WorkOrder> findAll(){
        return workOrderRepo.findAll();
    }

    public WorkOrder findOne(long id){
        return workOrderRepo.findOne(id);
    }

    public WorkOrder saveOrUpdate(WorkOrder workOrder){
        return workOrderRepo.save(workOrder);
    }
}
