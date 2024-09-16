package com.example.Booking.Service.service;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class fullBookingResponse {
    private Long flightId;
    private String passengerName;
    private LocalDateTime bookingTime;
    private double totalPrice;
    List<Flight>flights;
}
