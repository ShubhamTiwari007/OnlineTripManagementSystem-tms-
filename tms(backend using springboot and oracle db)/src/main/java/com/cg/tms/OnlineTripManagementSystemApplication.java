package com.cg.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Team 6 [Members - Mayank Shivhare, Shubham Tiwari, Rhushikesh Tavdar,
 *         Ashish Dnyanoba Bhosale, Pratik Sudhir Bhangare]
 */
@SpringBootApplication
@EnableSwagger2
public class OnlineTripManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineTripManagementSystemApplication.class, args);
	}

}
