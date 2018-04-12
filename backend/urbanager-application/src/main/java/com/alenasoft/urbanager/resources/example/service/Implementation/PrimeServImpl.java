package com.alenasoft.urbanager.resources.example.service.Implementation;

import com.alenasoft.urbanager.resources.example.service.Interfaces.PrimeServ;

public class PrimeServImpl implements PrimeServ {
    public boolean numberIntegerIsPrime(int primeNumber) {
        if (primeNumber <= 1)
            return false;

        int index = 2;
        while (index <= (primeNumber / 2)) {
            if (primeNumber % index == 0)
                return false;

            index++;
        }
        return true;
    }
}
