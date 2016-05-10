package com.rbc.fruitbasket;

import java.math.BigDecimal;
import java.util.List;

public interface Basket {

    BigDecimal getTotalCostOfItems();

    List<Item> getItems();

}
