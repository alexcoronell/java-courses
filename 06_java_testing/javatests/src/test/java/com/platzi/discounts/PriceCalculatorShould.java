package com.platzi.discounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorShould {

    private PriceCalculator priceCalculator;

    @BeforeEach
    void setup(){
        priceCalculator = new PriceCalculator();
    }

    @Test
    void total_zero_when_there_are_no_prices(){
        assertThat(priceCalculator.getTotal(), is(0.0));
    }

    @Test
    void total_is_the_sume_of_prices(){
        priceCalculator.addPrice(10.2);
        priceCalculator.addPrice(15.5);
        assertThat(priceCalculator.getTotal(), is(25.7));
    }

    @Test
    void apply_discount_to_prices(){
        priceCalculator.addPrice(12.5);
        priceCalculator.addPrice(17.5);
        priceCalculator.setDiscount(50);
        assertThat(priceCalculator.getTotal(), is(15.0));
    }

}