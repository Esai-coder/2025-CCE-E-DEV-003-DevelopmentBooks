package com.example.demoservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.demo.model.Book;
import com.example.demo.service.PriceCalculatorService;

public class PriceCalculatorServiceTest {

	private final PriceCalculatorService service = new PriceCalculatorService();

    @Test
    void testSingleBook() {
        BigDecimal price = service.calculatePrice(List.of(Book.CLEAN_CODE));
        assertEquals(BigDecimal.valueOf(50.00).setScale(2), price);
    }

    @Test
    void testTwoDifferentBooks() {
        BigDecimal price = service.calculatePrice(List.of(Book.CLEAN_CODE, Book.CLEAN_CODER));
        assertEquals(BigDecimal.valueOf(95.00).setScale(2), price);
    }

    @Test
    void testThreeDifferentBooks() {
        BigDecimal price = service.calculatePrice(List.of(Book.CLEAN_CODE, Book.CLEAN_CODER, Book.CLEAN_ARCHITECTURE));
        assertEquals(BigDecimal.valueOf(135.00).setScale(2), price);
    }

    @Test
    void testExampleCaseFromKata() {
        List<Book> books = List.of(
            Book.CLEAN_CODE, Book.CLEAN_CODE,
            Book.CLEAN_CODER, Book.CLEAN_CODER,
            Book.CLEAN_ARCHITECTURE, Book.CLEAN_ARCHITECTURE,
            Book.TDD_BY_EXAMPLE,
            Book.LEGACY_CODE
        );

        BigDecimal price = service.calculatePrice(books);
        assertEquals(BigDecimal.valueOf(322.50).setScale(2), price);
    }
}
