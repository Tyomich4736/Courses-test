package by.nosevich.courses.test.logger;

import java.time.LocalDateTime;

public class ConsoleLogger implements Logger {
    @Override
    public void printMessage(String message) {
        System.out.println(LocalDateTime.now() + ": " + message);
    }
}
