package dev.vmehra.mcp.research.paper.customer.persona;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactRecordReader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<ContactRecord> readAllCallRecordsFromResources() {

        List<ContactRecord> contactRecords = new ArrayList<>();
        try {
            // Match all JSON files in classpath:resources folder
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath:contact-records/*.json");

            for (Resource resource : resources) {
                try (InputStream is = resource.getInputStream()) {
                    ContactRecord contactRecord = objectMapper.readValue(is, ContactRecord.class);
                    contactRecords.add(contactRecord);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load contact records", e);
        }
        return contactRecords;
    }
}
