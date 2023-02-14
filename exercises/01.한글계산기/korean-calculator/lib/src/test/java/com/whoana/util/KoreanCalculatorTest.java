package com.whoana.util;

import java.util.List;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.Assert; 

public class KoreanCalculatorTest {

	Logger logger = Logger.getLogger(KoreanCalculatorTest.class.getName());
	
	KoreanCalculator kc = new KoreanCalculator();
	
	@Test
	public void testCalculate() throws Exception {
		Assert.assertEquals("육백일", kc.calculate("오백일 + 백"));
	}

	@Test
	public void testToKorNumber() throws Exception {
		Assert.assertEquals("구천구백구십구", kc.toKorNumber(9999)); 
	}
 

	@Test
	public void testToNumbers() throws Exception {
		List<Integer> numbers = kc.toNumbers("일 + 이 + 삼");
		Assert.assertNotNull("numbers must not be null!", numbers);
		for (Integer num : numbers) {
			logger.info("num:" + num);
		}
	}

	@Test
	public void testToNumber() throws Exception {
		Assert.assertEquals(new Integer(999), kc.toNumber("구백구십구")); 
	}

}
