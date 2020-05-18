package com.nathanducey.main;

import java.util.ArrayList;
import java.util.List;

public class PrimeService {
	
	public List<Integer> findPrimes(Integer inputNum) {
		List<Integer> pList = new ArrayList<>();
		
		if(inputNum == 0 || inputNum == 1) {
			return pList;
		}
		
		for (int i = 1; i <= inputNum; i++) {            
            if (primeCheck(i)) {
                pList.add(i);
            }
        }
		
		return pList;
	}
	
	public static boolean primeCheck(int checkNum) {
        int remainder;
        
        if(checkNum == 1) {
        	return false;
        }
        
        for (int i = 2; i <= checkNum / 2; i++) {
            remainder = checkNum % i;
            if (remainder == 0) {
                return false;
            }
        }
        return true; 
    }

}
