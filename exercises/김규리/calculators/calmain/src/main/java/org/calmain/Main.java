package org.calmain;

import java.util.Arrays;

import org.calclibrary.App;
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		App calc = new App();
		String val = Arrays.toString(args);
		val = val.replace("[", "").replace("]", "").replace(",", "");
		int answer = calc.calcLib(val);
		String realAnswer = "";
		System.out.print(val + " = " + realAnswer);
		realAnswer = calc.numTohangul(answer);
	}

}
