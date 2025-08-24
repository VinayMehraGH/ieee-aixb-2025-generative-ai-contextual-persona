package dev.vmehra.mcp.research.paper.customer.persona;

import java.util.List;

public record ContactRecord (
        String call_id,
        String title,
        String date,
        int duration_minutes,
        Customer customer,
        Agent agent,
        ReservationDetails reservation_details,
        List<Dialogue> dialogue,
        String summary,
        String model_name
) {
    public static record Customer(
            String name,
            String phone
    ) {}

    public static record Agent(
            String name
    ) {}

    public static record ReservationDetails(
            String resort,
            String check_in,
            String check_out,
            int nights,
            String room_type,
            String view,
            String room_number,
            String confirmation_number,
            List<String> includes
    ) {}

    public static record Dialogue(
            String speaker,
            String text
    ) {}
}

