package com.swm.datatracker.services;

import com.swm.datatracker.models.User;
import com.swm.datatracker.models.WorkOrder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.swm.datatracker.respositories.WorkOrderRepository;

import java.util.ArrayList;
import java.util.List;

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


    //Copied similar format from the Springblog Posts


    public WorkOrder save(WorkOrder workOrder) {
//        post.setId(posts.size() + 1);
//        posts.add(post);
        return workOrderRepo.save(workOrder);
    }

    public WorkOrder edit(WorkOrder post){
        return workOrderRepo.save(post);
    }

    public void delete(long id){
        WorkOrder deletedPost = workOrderRepo.findOne(id);
        Iterable<WorkOrder> updatedPosts = workOrderRepo.findAll();
        for(WorkOrder currentPost : updatedPosts){
            if (currentPost.getId() == deletedPost.getId()){
                workOrderRepo.delete(currentPost.getId());
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



    public List<WorkOrder> search (String string){
        return workOrderRepo.findAllByCategoryContainsOrDescriptionContainsOrCustomerContains(string, string, string);
    }


}
