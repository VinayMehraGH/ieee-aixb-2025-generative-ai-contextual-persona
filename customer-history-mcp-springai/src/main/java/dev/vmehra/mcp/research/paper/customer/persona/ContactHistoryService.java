package dev.vmehra.mcp.research.paper.customer.persona;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ContactHistoryService {

    private ContactRecordReader contactRecordReader;

    private final List<ContactRecord> contacts = new ArrayList<>();

    @Tool(name = "get_contact_history_for_customer", description = "Get all contact records for a customer")
    public List<ContactRecord> getContactHistory(String customerName) {
        return contacts
                .stream()
                .filter(contactRecord -> contactRecord.customer().name().equalsIgnoreCase(customerName))
                .toList();
    }

    @PostConstruct
    public void init() {
        contacts.addAll(contactRecordReader.readAllCallRecordsFromResources());
    }
}
