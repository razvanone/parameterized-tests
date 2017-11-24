package com.razvanm.romannums;

import java.util.HashMap;
import java.util.Map;

public class RomanNums {
	private static Character[] rnChars = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
	// Array including numerals in ascending order
	private static String[] rnCharsAscending = { "I", "V", "X", "L", "C", "D", "M" };
	private static int[] rnVals = { 1000, 500, 100, 50, 10, 5, 1 };
	private static Map<Character, Integer> valueLookup = new HashMap<>();

	static {
		for (int i = 0; i < rnChars.length; i++) {
			valueLookup.put(rnChars[i], rnVals[i]);
		}
	}

	public static int convertFromRoman(String romanNumeral) {
		int retVal = 0;
		for (int i = 0; i < romanNumeral.length(); i++) {
			int addVal = valueLookup.get(romanNumeral.charAt(i));
			retVal += (i < romanNumeral.length() - 1) && (addVal < valueLookup.get(romanNumeral.charAt(i + 1)))
					? -addVal : addVal;
		}
		return retVal;
	}

	public static void convertFromArabic(RomanArabicPair romanArabicPair) {
		String asRomanNumerals = "";
		int arabicNumeral = romanArabicPair.getArabicNum();

		int i = 0; // Index used to keep track which digit we are translating
		while (arabicNumeral > 0) {
			// Get the last digit of the number
			switch (arabicNumeral % 10) {
			case 1:
				asRomanNumerals = rnCharsAscending[i] + asRomanNumerals;
				break;
			case 2:
				asRomanNumerals = rnCharsAscending[i] + rnCharsAscending[i] + asRomanNumerals;
				break;
			case 3:
				asRomanNumerals = rnCharsAscending[i] + rnCharsAscending[i] + rnCharsAscending[i] + asRomanNumerals;
				break;
			case 4:
				asRomanNumerals = rnCharsAscending[i] + rnCharsAscending[i + 1] + asRomanNumerals;
				break;
			case 5:
				asRomanNumerals = rnCharsAscending[i + 1] + asRomanNumerals;
				break;
			case 6:
				asRomanNumerals = rnCharsAscending[i + 1] + rnCharsAscending[i] + asRomanNumerals;
				break;
			case 7:
				asRomanNumerals = rnCharsAscending[i + 1] + rnCharsAscending[i] + rnCharsAscending[i] + asRomanNumerals;
				break;
			case 8:
				asRomanNumerals = rnCharsAscending[i + 1] + rnCharsAscending[i] + rnCharsAscending[i]
						+ rnCharsAscending[i] + asRomanNumerals;
				break;
			case 9:
				asRomanNumerals = rnCharsAscending[i] + rnCharsAscending[i + 2] + asRomanNumerals;
				break;
			}
			// Divide by ten to exclude the previously computed last-digit
			arabicNumeral = (int) arabicNumeral / 10;
			i += 2;
		}
		romanArabicPair.setRomanNum(asRomanNumerals);
	}
}
