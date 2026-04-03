package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntegerContainerTest {

    private IntegerContainer container;

    @BeforeEach
    void setUp() {
        container = new IntegerContainer();
    }

    @Test
    void newContainerShouldBeEmpty() {
        assertEquals(0, container.size());
    }

    @Test
    void addShouldIncreaseSize() {
        container.add(10);
        container.add(20);
        assertEquals(2, container.size());
    }

    @Test
    void getShouldReturnCorrectValue() {
        container.add(42);
        assertEquals(42, container.get(0));
    }

    @Test
    void removeShouldDecreaseSize() {
        container.add(1);
        container.add(2);
        container.remove(0);
        assertEquals(1, container.size());
    }

    @Test
    void removeShouldShiftElements() {
        container.add(1);
        container.add(2);
        container.add(3);
        container.remove(0);
        assertEquals(2, container.get(0));
    }

    @Test
    void getShouldThrowOnInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(0));
    }

    @Test
    void containerShouldGrowBeyondInitialCapacity() {
        for (int i = 0; i < 20; i++) {
            container.add(i);
        }
        assertEquals(20, container.size());
    }

    @Test
    void removeShouldThrowOnInvalidIndex() {
        container.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(5));
    }

    @Test
    void getShouldThrowOnNegativeIndex() {
        container.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(-1));
    }
}