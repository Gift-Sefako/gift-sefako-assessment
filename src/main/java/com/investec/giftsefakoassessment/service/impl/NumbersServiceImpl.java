package com.investec.giftsefakoassessment.service.impl;

import com.investec.giftsefakoassessment.service.NumbersService;
import org.springframework.stereotype.Service;

@Service
public class NumbersServiceImpl implements NumbersService {


    @Override
    public int highestCommonFactor(int[] numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = findHighestCommonDivisor(result, numbers[i]);
            if (result == 1) {
                return 1;
            }
        }
        return result;
    }


    private int findHighestCommonDivisor(int before, int next) {
        while (next != 0) {
            int temp = next;
            next = before % next;
            before = temp;
        }

        return before;
    }
}
