package com.alenasoft.urbanager.resources.example.service.Implementation;

public class PrimeSeriesServImpl {
    public int[] getNFirstNumberPrimeSeries(int primeNumberToGenerate) {
        int[] list = new int[primeNumberToGenerate];
        int number = 2;
        int pointer = 0;
        PrimeServImpl serv = new PrimeServImpl();
        while (pointer < list.length){
            if (serv.numberIntegerIsPrime(number)){
                list[pointer] = number;
                pointer++;
            }
            number++;
        }
        return list;
    }
}
