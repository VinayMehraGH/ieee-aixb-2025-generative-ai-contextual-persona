package dev.vmehra.mcp.config;

import dev.vmehra.mcp.research.paper.customer.persona.BookingHistoryService;
import dev.vmehra.mcp.research.paper.customer.persona.ContactHistoryService;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ToolsConfig {

    @Bean
    public List<ToolCallback> tools(ContactHistoryService contactHistoryService) {
        return List.of(ToolCallbacks.from(contactHistoryService));
    }
}
