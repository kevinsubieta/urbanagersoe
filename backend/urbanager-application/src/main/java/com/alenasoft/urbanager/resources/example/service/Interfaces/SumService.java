package com.alenasoft.urbanager.resources.example.service.Interfaces;

import com.alenasoft.urbanager.api.Result;

public interface SumService {
    long sumTwoNumbersIntegers(int num1, int num2);
    Result getResultOfSumById(long id);
}
