package com.rbc.fruitbasket;

import java.math.BigDecimal;

public enum FruitItem implements Item {

    BANANA(new BigDecimal("0.50")),
    ORANGE(new BigDecimal("0.25")),
    APPLE(new BigDecimal("0.10")),
    LEMON(new BigDecimal("0.30")),
    PEACH(new BigDecimal("0.20"))
    ;

    private final BigDecimal price;

    FruitItem(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
