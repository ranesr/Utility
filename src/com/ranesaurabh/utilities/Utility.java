package com.ranesaurabh.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
	private static Pattern pattern;
	private static Matcher matcher;
 
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String SSN_PATTERN = "[0-8][\\d]{8}";
	private static final String INVALID_SSN_PATTERN_1 = "[6]{3}[\\d]{6}";
	private static final String INVALID_SSN_PATTERN_2 = "[0]{3}[\\d]{6}";
	private static final String INVALID_SSN_PATTERN_3 = "[\\d]{5}[0]{4}";
	private static final String INVALID_SSN_PATTERN_4 = "[\\d]{3}[0]{2}[\\d]{4}";
	private static final String NPI_PATTERN = "[12][\\d]{9}";
	private static final int[] INDIVIDUAL_ARRAY = {0,1,2,3,4,5,6,7,8,9};
	private static final int[] DOUBLE_ARRAY = {0,2,4,6,8,1,3,5,7,9};

	public static boolean isEmail(String email) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static boolean isSSN(String ssn) {
		pattern = Pattern.compile(INVALID_SSN_PATTERN_1);
		matcher = pattern.matcher(ssn);
		if(!matcher.matches()) {
			pattern = Pattern.compile(INVALID_SSN_PATTERN_2);
			matcher = pattern.matcher(ssn);
			if(!matcher.matches()) {
				pattern = Pattern.compile(INVALID_SSN_PATTERN_3);
				matcher = pattern.matcher(ssn);
				if(!matcher.matches()) {
					pattern = Pattern.compile(INVALID_SSN_PATTERN_4);
					matcher = pattern.matcher(ssn);
					if(!matcher.matches()) {
						pattern = Pattern.compile(SSN_PATTERN);
						matcher = pattern.matcher(ssn);
						return matcher.matches();
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean isNPI(String npi) {
		pattern = Pattern.compile(NPI_PATTERN);
		matcher = pattern.matcher(npi);
		if(matcher.matches()) {
			int sum = 24;
			for(int i=0; i<9; i++) {
				int offset = (int) (npi.charAt(i) - '0');
				if(i%2 == 0) {
					sum += DOUBLE_ARRAY[offset];
				} else {
					sum += INDIVIDUAL_ARRAY[offset];
				}
			}
			int check = (int) (npi.charAt(9) - '0');
			if((10 - sum%10) == check) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}