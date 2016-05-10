package com.rbc.fruitbasket.main;

import com.rbc.fruitbasket.Basket;
import com.rbc.fruitbasket.BasketImpl;
import com.rbc.fruitbasket.FruitItem;
import lombok.Getter;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.text.NumberFormat;
import java.util.Arrays;

public class BasketApp {

    @Getter
    public static class BasketAppParameters {
        @Option(name = "-i", aliases = { "--items"}, required = true, usage = "List of items")
        private FruitItem[] items;
    }

    public static void main(String[] args) {
        BasketAppParameters parameters = new BasketAppParameters();
        CmdLineParser parser = new CmdLineParser(parameters);
        try {
            parser.parseArgument(args);
            Basket basket = BasketImpl.builder()
                    .items(Arrays.asList(parameters.getItems()))
                    .build();
            System.out.println(String.format("Basket contents : %s", basket.getItems()));
            System.out.println(String.format("Total cost of contents : %s",
                    NumberFormat.getCurrencyInstance().format(basket.getTotalCostOfItems())));
        } catch (CmdLineException clex) {
            System.err.println(clex.getMessage());
            System.err.println("Example Usage: java BasketApp -i=<item1> -i=<item2>");
            parser.printUsage(System.err);
        }
    }

}
