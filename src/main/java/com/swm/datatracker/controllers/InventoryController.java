package com.swm.datatracker.controllers;

import com.swm.datatracker.models.Inventory;
import com.swm.datatracker.models.RequestedQuantity;
import com.swm.datatracker.respositories.UserRepository;
import com.swm.datatracker.services.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InventoryController {


    /**------------------------------------------------------------**\
     |                      Services Property                         |
     | This property is the connection (intermediary) that allows     |
     | the controller class to access the services class              |
     |                                                                |
     /**____________________________________________________________**/

    private InventoryService inventorySvc;
    private UserRepository userRepo;
    /**---------------------------------------------------------------------------**\
     |                       Dependency Injection                                    |
     |                                                                               |
     | This is the constructor that takes the services property as a parameter       |
     | for the CONTROLLER to access the SERVICES class                               |
     | that will house the construction of data that the CONTROLLER will pull from   |
     | to render information in a logical way on the TEMPLATES.                      |
     |                                                                               |
     |                                                                               |
     | This is called  or passing things into the constructor of an object.          |
     /**___________________________________________________________________________**/

    public InventoryController(InventoryService inventorySvc, UserRepository userRepo){
        this.inventorySvc = inventorySvc;
        this.userRepo = userRepo;
    }
//--------------------------------------- MAPPING TO THE VIEWER ---------------------------------------\\


    //Takes all of the inventory from the database
    @GetMapping("/inventory")
    public String inventoryIndex(Model vModel) {
        vModel.addAttribute("inventory", inventorySvc.all());
        return "inventory/index";
    }


    @GetMapping("/inventory/{id}")
    public String individualPost(@PathVariable int id, Model vModel) {
        vModel.addAttribute("post", inventorySvc.findOne(id));
        return "inventory/show";
    }


    //Directs user to the form to create a new inventory object
    @GetMapping("/inventory/create")
    public String showCreateForm(Model vModel) {
        vModel.addAttribute("inventory", new Inventory());
        return "inventory/create";
    }

    /**
     1) Takes the user's input, creates the inventory item, adds it to the database, redirects the user to the inventory page
     2) using the authentication method we can request parameters from the inventory list
     3) take the item and add it to the list
     4) and get the id of the user who added the item and set it to them
     5) Create a User object variable that takes the SecurityContextHolder; get the context, get authentication, get principal
     this will get info from the JSP(view)
     */

    @PostMapping("/inventory/create")
    public String createInventoryItem(@ModelAttribute Inventory item){

//        User loguser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        inventorySvc.create(item);
        return "redirect:/inventory";
    }

    //Finds a inventory id, redirects to the edit page
    //to update the form you have to know which id (parameter) you are looking for
    @GetMapping("/inventory/{id}/edit")
    public String showUpdateForm(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("inventory", inventorySvc.findOne(id));
        return "inventory/edit";
    }
    //User updates changes to the inventory, edits the inventory in database and displays new inventory list
    @PostMapping("/inventory/{id}/edit")
    public String updateForm(@ModelAttribute Inventory item){
        inventorySvc.edit(item);
        return "redirect:/inventory";
    }
//
//    //search for inventory based on terms in name or size
//    @GetMapping("#")
//    public String showResults(@PathVariable String term, Model viewModel){
//        viewModel.addAttribute("inventory",inventorySvc.searchDBNameOrSize(term));
//        return "inventory/index";
//    }
//
    //find the inventory based on the id, then delete the inventory from the service, redirect the user to the home page: !!!CAUTION VERY DANGEROUS!!!
    @PostMapping("/inventory")
    public void deleteInventoryItem(@PathVariable long id){
        inventorySvc.delete(id);
    }


    @GetMapping("/inventory/{id}/decrement/{quantity}")
    public String decrement(@PathVariable long id, @PathVariable long quantity){
       Inventory item = inventorySvc.findOne(id);
       long currentQuantity = item.getQuantity();
        item.setQuantity(currentQuantity - quantity);
        inventorySvc.edit(item);
        System.out.println(inventorySvc.findOne(id).getQuantity());
       return "redirect:/inventory/{id}/edit";
    }

    @GetMapping("/inventory/{id}/increment/{quantity}")
    public String increment(@PathVariable long id, @PathVariable long quantity){
        Inventory item = inventorySvc.findOne(id);
        long currentQuantity = item.getQuantity();
        item.setQuantity(currentQuantity + quantity);
        inventorySvc.edit(item);
        System.out.println(inventorySvc.findOne(id).getQuantity());
        return "redirect:/inventory/{id}/edit";
    }

}
