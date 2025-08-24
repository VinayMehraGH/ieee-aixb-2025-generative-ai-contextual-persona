package dev.vmehra.mcp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"dev.vmehra.mcp"
})
public class CustomerHistoryMcpSpringAIApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerHistoryMcpSpringAIApplication.class, args);
	}
}
