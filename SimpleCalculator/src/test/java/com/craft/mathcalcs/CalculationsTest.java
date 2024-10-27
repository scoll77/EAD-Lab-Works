package com.craft.mathcalcs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.craft.mathclass.Calculations;

public class CalculationsTest {
	Calculations calc = new Calculations();
	@Test
	public void testDivision () {
		assertEquals(10, calc.division(20,2));
	}
}
