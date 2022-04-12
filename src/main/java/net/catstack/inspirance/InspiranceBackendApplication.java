package net.catstack.inspirance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class InspiranceBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(InspiranceBackendApplication.class, args);
    }
}
