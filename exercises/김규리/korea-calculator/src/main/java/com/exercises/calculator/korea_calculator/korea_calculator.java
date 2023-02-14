/**
 * 
 */
package com.exercises.calculator.korea_calculator;

import java.util.Arrays;

import com.exercises.calc.CalcLib;

/**
 * @author deare
 *
 */
public class korea_calculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CalcLib calc = new CalcLib();
		String val = Arrays.toString(args);
		val = val.replace("[", "").replace("]", "").replace(",", "");
		int answer = calc.calcLib(val);
		String realAnswer = "";
		System.out.print(val + " = " + realAnswer);
		realAnswer = calc.numTohangul(answer);
	}

}
