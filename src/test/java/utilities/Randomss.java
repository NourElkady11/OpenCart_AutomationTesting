package utilities;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;

public class Randomss {
	
	public static String randomNumbers(int digits) {
	    String number = "";
	    for (int i = 0; i < digits; i++) {
	        number += ThreadLocalRandom.current().nextInt(0, 10);
	    }
	    return number;
	}
	
	public static String randomAlphaCharcters() {
	    return RandomStringUtils.secure().nextAlphanumeric(8);
	}
	
	public static String RandomMixedChars_WithSpecialChars_WithNumbers_WithUpperAndLowerCases() {
		
		return ("A"+randomAlphaCharcters()+"a"+"@"+randomNumbers(5));
	}

}
