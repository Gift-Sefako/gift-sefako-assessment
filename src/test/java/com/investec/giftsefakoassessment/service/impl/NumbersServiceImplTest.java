package com.investec.giftsefakoassessment.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NumbersServiceImplTest {

    @Autowired
    NumbersServiceImpl numbersService;

    @Test
    public void testHighestCommonFactor_correctInput_highestCommonFactor_7() {
        int[] numbers = {21, 14, 49, 70};
        int result = numbersService.highestCommonFactor(numbers);
        assertEquals(7, result);
    }

    @Test
    public void testHighestCommonFactor_correctInput_highestCommonFactor_2() {
        int[] numbers = {8, 4, 2, 50, 100, 12};
        int result = numbersService.highestCommonFactor(numbers);
        assertEquals(2, result);
    }

    @Test
    public void testHighestCommonFactor_incorrectInput_emptyArray() {
        int[] numbers = {};
        int result = numbersService.highestCommonFactor(numbers);
        assertEquals(-1, result);
    }

    @Test
    public void testHighestCommonFactor_incorrectInput_nullArray() {
        int result = numbersService.highestCommonFactor(null);
        assertEquals(-1, result);
    }

    @Test
    public void testHighestCommonFactor_noHighestCommonFactorShouldReturn1() {
        int[] numbers = {90, 8, 7, 5, 300};
        int result = numbersService.highestCommonFactor(numbers);
        assertEquals(1, result);
    }
}
