package org.DRTCT.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.DRTCT.dto.request.BookTicketRequest;
import org.DRTCT.entity.Passenger;
import org.DRTCT.entity.Station;
import org.DRTCT.entity.Ticket;
import org.DRTCT.entity.Train;
import org.DRTCT.repository.TicketRepository;
import org.DRTCT.service.PassengerService;
import org.DRTCT.service.StationService;
import org.DRTCT.service.TicketService;
import org.DRTCT.service.TrainService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TrainService trainService;
    private final StationService stationService;
    private final PassengerService passengerService;

    @Override
    public void bookTicket(BookTicketRequest bookTicketRequest) {
        log.info("bookTicket: method called for trainId={}", bookTicketRequest.trainId());
        List<Ticket> ticketList = buildTicket(bookTicketRequest);
        ticketRepository.saveAll(ticketList);
    }

    private List<Ticket> buildTicket(BookTicketRequest bookTicketRequest) {
        Train train = trainService.getTrainById(bookTicketRequest.trainId());
        Station source = stationService.getStationById(bookTicketRequest.sourceStationId());
        Station destination = stationService.getStationById(bookTicketRequest.destinationStationId());
        return bookTicketRequest
                .passengerIds()
                .stream()
                .map((passengerId) -> {
                    Passenger passenger = passengerService.getPassengerById(passengerId);
                    Ticket ticket = new Ticket();
                    ticket.setTrain(train);
                    ticket.setBoardingStation(source);
                    ticket.setDestinationStation(destination);
                    ticket.setPassenger(passenger);
                    return ticket;
                })
                .toList();
    }
}
