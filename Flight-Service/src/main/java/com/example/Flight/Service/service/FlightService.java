package com.example.Flight.Service.service;

import com.example.Flight.Service.entity.Flight;
import com.example.Flight.Service.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> findFlights(String origin, String destination, LocalDateTime departureTimeStart, LocalDateTime departureTimeEnd) {
        return flightRepository.findByOriginAndDestinationAndDepartureTimeBetween(origin, destination, departureTimeStart, departureTimeEnd);
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> findFlightsByBookingId(Integer bookingId) {
        return flightRepository.findAllByBookingId(bookingId);
    }
}