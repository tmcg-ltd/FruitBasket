package com.rbc.fruitbasket;

import lombok.Builder;
import lombok.Singular;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Builder
public class BasketImpl implements Basket {

    @Singular
    private final List<Item> items;

    @Override
    public BigDecimal getTotalCostOfItems() {
        return items.parallelStream()
                .map(i -> i.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
