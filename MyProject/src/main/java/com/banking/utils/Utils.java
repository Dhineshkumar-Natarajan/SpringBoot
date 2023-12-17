package com.banking.utils;

import java.util.Random;

public class Utils {

	public static String generateAccountNumber() {
		
		Random random = new Random(); 
        long randomNumber = Math.abs(random.nextLong()); 
        String randomString = Long.toString(randomNumber); 
        String tenDigitNumber = randomString.substring(0, 10); 

		return tenDigitNumber;
	}
	
}
