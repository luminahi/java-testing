package com.luminahi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TestInstance(value = Lifecycle.PER_CLASS)
public class CarTests {

    private final static Logger log = LoggerFactory.getLogger(CarTests.class);
    private List<Car> cars = new ArrayList<>();

    @BeforeAll
    void initAll() {
        log.info("adding cars to list");
        cars.add(new Car("Ford", "Mustang", 2023, Color.GREEN));
        cars.add(new Car("Fiat", "Mobi", 2020, Color.WHITE));
        cars.add(new Car("Unknown", "Unknown"));
        cars.add(new Car(null, null));
        cars.add(new Car("Toyota", "Corolla", 2006, Color.BLACK));
        log.info("all cars added");
    }
    
    @Test
    void testGetSize() {
        assertEquals(5, cars.size());
    }

    @Test
    void testGetFirst() {
        cars.stream()
            .findFirst()
            .ifPresentOrElse(
                (res) -> {
                    log.info(res.toString());
                }, 
                () -> {
                    log.error("car wasted");
                    fail();
                });
    }

    @AfterAll
    void testRemoveAll() {
        cars.removeAll(cars);
        assertFalse(() -> cars.size() != 0);
    }
}
