package com.example.Booking.Service;

import com.example.Booking.Service.service.Flight;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "flight-service")
public interface FlightClient {
    @GetMapping("flights/booking/{booking-id}")
    List<Flight>findAllFlightsByBooking(@PathVariable("booking-id") Integer bookingId);

}
