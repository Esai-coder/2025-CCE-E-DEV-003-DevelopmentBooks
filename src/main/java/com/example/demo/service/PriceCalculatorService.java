package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.model.Book;

@Service
public class PriceCalculatorService {
	private static final BigDecimal BOOK_PRICE = BigDecimal.valueOf(50);

    private static final Map<Integer, BigDecimal> DISCOUNTS = Map.of(
        1, BigDecimal.valueOf(1.00),
        2, BigDecimal.valueOf(0.95),
        3, BigDecimal.valueOf(0.90),
        4, BigDecimal.valueOf(0.80),
        5, BigDecimal.valueOf(0.75)
    );

    public BigDecimal calculatePrice(List<Book> books) {
        Map<Book, Integer> bookCounts = new HashMap<>();
        for (Book book : books) {
            bookCounts.put(book, bookCounts.getOrDefault(book, 0) + 1);
        }

        List<Integer> groupSizes = new ArrayList<>();
        while (!bookCounts.isEmpty()) {
            Set<Book> group = new HashSet<>();
            for (Book book : new HashSet<>(bookCounts.keySet())) {
                if (!group.contains(book)) {
                    group.add(book);
                    bookCounts.put(book, bookCounts.get(book) - 1);
                    if (bookCounts.get(book) == 0) {
                        bookCounts.remove(book);
                    }
                }
            }
            groupSizes.add(group.size());
        }

        BigDecimal total = BigDecimal.ZERO;
        for (int size : groupSizes) {
            BigDecimal discount = DISCOUNTS.get(size);
            BigDecimal groupPrice = BOOK_PRICE.multiply(BigDecimal.valueOf(size)).multiply(discount);
            total = total.add(groupPrice);
        }

        return total.setScale(2, RoundingMode.HALF_UP);
    }
}
