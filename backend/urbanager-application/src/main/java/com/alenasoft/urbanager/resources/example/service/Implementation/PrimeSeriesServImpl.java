package com.alenasoft.urbanager.resources.example.service.Implementation;

import com.alenasoft.urbanager.resources.example.service.Interfaces.PrimeSeriesServ;

public class PrimeSeriesServImpl implements PrimeSeriesServ {
    public int[] getNFirstNumberPrimeSeries(int primeNumberToGenerate) {
        if (primeNumberToGenerate < 0) return new int[0];
        int[] list = new int[primeNumberToGenerate];
        int number = 2;
        int pointer = 0;
        PrimeServImpl serv = new PrimeServImpl();
        while (pointer < list.length) {
            if (serv.numberIntegerIsPrime(number)) {
                list[pointer] = number;
                pointer++;
            }
            number++;
        }
        return list;
    }
}
