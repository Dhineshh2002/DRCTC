package org.DRTCT.controller;

import org.DRTCT.entity.Train;
import org.DRTCT.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping (value = "/get")
    public ArrayList<Train> getTrains() {
        return trainService.getTrains();
    }
}
