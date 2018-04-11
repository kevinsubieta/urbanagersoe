package com.alenasoft.urbanager.resources.example.service.Implementation;

public class PrimeServImpl {
    public boolean numberIntegerIsPrime(int primeNumber) {
        int index = 2;
        while (index <= (primeNumber / 2)) {
            if (primeNumber % index == 0)
                return false;

            index++;
        }
        return true;
    }
}
