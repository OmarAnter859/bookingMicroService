package com.example.Booking.Service.service;

import com.example.Booking.Service.FlightClient;
import com.example.Booking.Service.entity.Booking;
import com.example.Booking.Service.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    public BookingService(FlightClient client) {
        this.client = client;}
    @Autowired
    private FlightClient client;


    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public fullBookingResponse findFlightsWithBooking(Integer bookingId) {
        Optional<Booking> bookingOptional = bookingRepository.findById(Long.valueOf(bookingId));
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            List<Flight> flights = client.findAllFlightsByBooking(bookingId);

            return fullBookingResponse.builder()
                    .passengerName(booking.getPassengerName())
                    .flightId(booking.getFlightId())
                    .totalPrice(booking.getTotalPrice())
                    .bookingTime(booking.getBookingTime())
                    .flights(flights)
                    .build();
        } else {
            return fullBookingResponse.builder()
                    .passengerName("not found")
                    .flightId(null)
                    .totalPrice(0.0)
                    .bookingTime(LocalDateTime.now())
                    .flights(Collections.emptyList())
                    .build();
        }
    }
   }
