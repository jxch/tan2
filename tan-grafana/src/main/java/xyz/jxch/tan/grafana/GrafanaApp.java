package xyz.jxch.tan.grafana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GrafanaApp {
    public static void main(String[] args) {
        SpringApplication.run(GrafanaApp.class, args);
    }
}
