package com.test.java17;

import com.test.java17.record.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@Slf4j
public class RecordTest {

    @BeforeAll
    public static void beforeAll() {
        Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.ALL);
    }

    @Test
    public void test() {
        log.warn("{}", 123);
        record Point(long x, long y ) {
        }
    }

    @Test
    public void testBlock() {
        String multiLineBeforeJava17 = "Line 1\n" +
                "Line 2\n" +
                "Line 3";

        String multiLine = """
                Line 1
                Line 2 %s
                Line 3
                """.formatted(1);

        String test = "";

        log.info(multiLineBeforeJava17);
        log.info(multiLine);
    }

    /**
     * You should never pass 'null' into method, but in Java 17, you can detect null in switch case.
     * @param in
     * @return
     */
    public int getInteger(String in) {
        return switch (in) {
            case null -> 88;
            case "a", "A" -> 1;
            case "b", "B" -> 2;
            default -> 9;
        };
    }

    @Test
    public void switchStatement() {
        log.info("{}", getInteger("a"));
        log.info("{}", getInteger("b"));
        log.info("{}", getInteger("c"));
        log.info("{}", getInteger(null));
    }

}
