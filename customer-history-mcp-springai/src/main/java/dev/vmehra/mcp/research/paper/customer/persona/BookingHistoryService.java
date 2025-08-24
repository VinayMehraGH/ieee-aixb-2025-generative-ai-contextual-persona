package dev.vmehra.mcp.research.paper.customer.persona;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingHistoryService {

    private final List<Booking> bookings = new ArrayList<>();

    @Tool(name = "get_booking_history_for_customer", description = "Get call records for a customer")
    public Booking geBookingHistory(long customerId) {
        return bookings.stream().filter(booking -> booking.customerId() == customerId).findFirst().orElse(null);
    }

    @PostConstruct
    public void init() {
        bookings.addAll(List.of(
                new Booking(1L, "Hotel","Miami, FL", "06/08/2025", "5 Guests"),
                new Booking(2L, "Flight", "Miami, FL", "06/08/2025", "1 Guest")));
    }
}
