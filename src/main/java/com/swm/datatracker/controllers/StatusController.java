package com.swm.datatracker.controllers;

import com.swm.datatracker.models.Status;
import com.swm.datatracker.respositories.StatusRepository;
import org.springframework.stereotype.Controller;

@Controller
public class StatusController {

    private StatusRepository statusRepository;

    public StatusController(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }


}
