package com.bitsbids.BITSBids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BitsBidsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitsBidsApplication.class, args);
	}

}
