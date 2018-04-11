package com.alenasoft.urbanager.resources.example.service.Implementation;

import com.alenasoft.urbanager.api.Result;
import com.alenasoft.urbanager.resources.example.dao.implementation.ResultDaoImpl;
import com.alenasoft.urbanager.resources.example.service.Interfaces.SumService;

import javax.inject.Inject;

public class SumServiceImpl implements SumService {

    @Inject
    private ResultDaoImpl dao;

    @Override
    public long sumTwoNumbersIntegers(int num1, int num2) {
        Result result = new Result();
        result.operation = "Sum";
        result.number1 = num1;
        result.number2 = num2;
        result.result = num1 + num2;
        return this.dao.create(result);
    }

    @Override
    public Result getResultOfSumById(long id) {
        return this.dao.getById(id);
    }
}
