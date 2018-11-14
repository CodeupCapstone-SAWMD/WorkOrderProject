package com.swm.datatracker.services;

import com.swm.datatracker.models.Status;
import com.swm.datatracker.models.User;
import com.swm.datatracker.models.WorkOrder;
import com.swm.datatracker.respositories.StatusRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.swm.datatracker.respositories.WorkOrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkOrderService {

    private WorkOrderRepository workOrderRepo;
    private StatusRepository statusRepo;



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


    //Copied similar format from the Springblog Posts


    public WorkOrder save(WorkOrder workOrder) {
        return workOrderRepo.save(workOrder);
    }

    public WorkOrder edit(WorkOrder post){
        return workOrderRepo.save(post);
    }

    public void delete(long id){
        WorkOrder deletedWorkOrder = workOrderRepo.findOne(id);
        Iterable<WorkOrder> updatedWorkOrders = workOrderRepo.findAll();
        for(WorkOrder currentWorkOrder : updatedWorkOrders){
            if (currentWorkOrder.getId() == deletedWorkOrder.getId()){
                workOrderRepo.delete(currentWorkOrder.getId());
            }
        }
    }

    public Iterable<WorkOrder> userWorkOrders() {
        Iterable<WorkOrder> allWorkOrders = findAll();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<WorkOrder> userWorkOrderList = new ArrayList<>();
        for(WorkOrder currentWorkOrder : allWorkOrders){
            if(currentWorkOrder.getCustomer().getId() == user.getId()){
                userWorkOrderList.add(currentWorkOrder);
            }
        }
        return userWorkOrderList;
    }


    public List<WorkOrder> statusList (long statusId){
        List<WorkOrder> list = new ArrayList<>();
        Iterable<WorkOrder> updatedWorkOrders = workOrderRepo.findAll();
        for (WorkOrder workorder: updatedWorkOrders){
            if (workorder.getStatus().getId() == statusId){
                list.add(workorder);
            }
        }
        return list;
    }

    public List<WorkOrder> listByUserAndStatus (User user, long statusId){
        Iterable<WorkOrder> allWorkOrders = workOrderRepo.findAll();

        System.out.println(user.getId());
        System.out.println(user);

        List<WorkOrder> filteredWorkOrders = new ArrayList<>();

        for(WorkOrder currentWorkOrder : allWorkOrders) {
            System.out.println(currentWorkOrder.getId());
            System.out.println(currentWorkOrder.getStatus().getId());
            if (currentWorkOrder.getCustomer().getId() == user.getId()
                && currentWorkOrder.getStatus().getId() == statusId) {

                filteredWorkOrders.add(currentWorkOrder);
            }
        }
        return filteredWorkOrders;
    }

    public List<WorkOrder> search (String string){
        return workOrderRepo.findAllByCategoryContainsOrDescriptionContainsOrCustomerContains(string, string, string);
    }

    public List <WorkOrder> findAllByCustomer(User user){
        return workOrderRepo.findAllByCustomer(user);
    }
}
