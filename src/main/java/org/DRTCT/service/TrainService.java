package org.DRTCT.service;

import org.DRTCT.entity.Train;
import org.DRTCT.entity.User;
import org.DRTCT.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public ArrayList<Train> getTrains() {
        ArrayList<Train> trains = new ArrayList<Train>();
        trainRepository.findAll().forEach(trains::add);
        return trains;
    }
}
