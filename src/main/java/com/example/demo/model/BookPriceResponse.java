package com.example.demo.model;

import java.math.BigDecimal;

public class BookPriceResponse {
	private BigDecimal totalPrice;

    public BookPriceResponse(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
