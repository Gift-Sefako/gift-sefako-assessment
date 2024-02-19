package com.investec.giftsefakoassessment.controller;

import com.investec.giftsefakoassessment.service.NumbersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/numbers/")
@RequiredArgsConstructor
public class NumbersTestController {

    private final NumbersService numbersService;

    @PostMapping("/findHighestCommonFactor")
    public int findHighestCommonFactor(@RequestBody int[] numbers) {
        return numbersService.highestCommonFactor(numbers);
    }
}
