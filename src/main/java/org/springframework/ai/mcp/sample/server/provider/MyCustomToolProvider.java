package org.springframework.ai.mcp.sample.server.provider;

import org.slf4j.Logger;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class MyCustomToolProvider {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MyCustomToolProvider.class);
    private final Random random = new Random();

    @Tool(description = "Get the current system time")
    public String getCurrentTime() {
        String currentTime = LocalDateTime.now().toString();
        logger.info("Current time: {}", currentTime);
        return currentTime;
    }

    @Tool(description = "Get a greeting message")
    public String getGreeting() {
        String greeting = "Hello, welcome to the tool service!";
        logger.info("Greeting: {}", greeting);
        return greeting;
    }

    @Tool(description = "Get a random number between 0 and 100")
    public int getRandomNumber() {
        int number = random.nextInt(101);
        logger.info("Random number: {}", number);
        return number;
    }

}