package com.microservice.serviceb.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/serverb")
public class GreetingController {

    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/greeting")
    public String greet() {
        System.out.println("\n\nhello");
        logger.info("Starting task execution...");
        logger.debug("Processing data...");
        logger.warn("Warning message");
        logger.error("Error message");
        logger.trace("Trace message");
        return "Hello from Service B!";
    }
}
