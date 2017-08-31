package com.org.tax.util;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class TaxCalculatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCalculateNormalTax() {
		BigDecimal itemValue = new BigDecimal("20.99");
		BigDecimal pinValue = new BigDecimal("11.25");
		assertEquals(new BigDecimal(3.70).setScale(2, BigDecimal.ROUND_HALF_EVEN),
				TaxCalculator.calculateTax(itemValue));
		assertEquals(new BigDecimal(2).setScale(2, BigDecimal.ROUND_HALF_EVEN), TaxCalculator.calculateTax(pinValue));
	}

	@Test
	public void testCalculateTaxWithAdditionalCharges() {
		BigDecimal cd1 = new BigDecimal("15.99");
		BigDecimal cd2 = new BigDecimal("14.99");
		assertEquals(new BigDecimal(4.05).setScale(2, BigDecimal.ROUND_HALF_EVEN),
				TaxCalculator.calculateTaxWithAdditionalCharges(cd1));
		assertEquals(new BigDecimal(3.9).setScale(2, BigDecimal.ROUND_HALF_EVEN),
				TaxCalculator.calculateTaxWithAdditionalCharges(cd2));
	}

	@Test
	public void testCalculateTaxForExemptedItems() {
		BigDecimal medItem1 = new BigDecimal("4.15");
		BigDecimal medItem2 = new BigDecimal("7.89");
		assertEquals(new BigDecimal(4.15).setScale(2, BigDecimal.ROUND_HALF_EVEN),
				medItem1);
		assertEquals(new BigDecimal(7.89).setScale(2, BigDecimal.ROUND_HALF_EVEN),
				medItem2);
	}

}
