package com.rbc.fruitbasket;

import org.junit.Test;

import java.math.BigDecimal;

import static com.rbc.fruitbasket.FruitItem.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BasketImplTest {

    @Test
    public void calculateNoItems() {
        Basket empty = BasketImpl.builder()
                .build();
        BigDecimal result = empty.getTotalCostOfItems();
        assertThat(result).isEqualByComparingTo("0");
    }

    @Test
    public void calculateItems() {
        Basket basket = BasketImpl.builder()
                .item(BANANA)
                .item(APPLE)
                .item(ORANGE)
                .item(LEMON)
                .item(PEACH)
                .build();
        BigDecimal result = basket.getTotalCostOfItems();
        assertThat(result).isEqualByComparingTo("1.35");
    }

}
