package com.org.tax.util;

import java.math.BigDecimal;


/**
 * @author prasanth
 * 
 * This is an utility class to calculate taxes.
 */
public class TaxCalculator {

	private static PropertiesLoader loader = PropertiesLoader.getInstance();
	private static final String TAX_RATE = "tax_rate";
	private static final String ROUND_OFF = "rounding_factor";
	private static final String ADDNL_RATE = "additional_rate";

	static BigDecimal taxRate = new BigDecimal(loader.getValue(TAX_RATE));
	static BigDecimal divisor = new BigDecimal(100.);
	static BigDecimal roundOff = new BigDecimal(loader.getValue(ROUND_OFF));
	static BigDecimal addnlTax = new BigDecimal(loader.getValue(ADDNL_RATE));

	
	/** Method to get the tax amount with fixed rate of interest and roundoff
	 * @param itemValue BigDecimal
	 * @return BigDecimal
	 */
	public static BigDecimal calculateTax(BigDecimal itemValue) {
		return calculateTaxWithRoundOff(calculateTaxByGivenPercentage(itemValue, taxRate), roundOff);
	}
	
	/** Method to get the tax amount with special rate of interest
	 * @param itemValue BigDecimal
	 * @return BigDecimal
	 */
	private static BigDecimal calculateTaxByGivenPercentage(BigDecimal itemValue, BigDecimal taxRate) {
		return itemValue.multiply(taxRate).divide(divisor, BigDecimal.ROUND_HALF_EVEN);
	}
 
	/** Method to get the roundoff amount for given taxed amount
	 * @param itemValue BigDecimal
	 * @return BigDecimal
	 */
	private static BigDecimal calculateTaxWithRoundOff(BigDecimal itemValue, BigDecimal roundOff) {
		return itemValue.divide(roundOff).setScale(0, BigDecimal.ROUND_UP).multiply(roundOff);
	}

	/** Method to get the tax amount with additional charges
	 * @param itemValue BigDecimal
	 * @return BigDecimal
	 */
	public static BigDecimal calculateTaxWithAdditionalCharges(BigDecimal itemValue) {
		return calculateTax(itemValue).add(addnlTax).divide(roundOff).setScale(0, BigDecimal.ROUND_UP)
				.multiply(roundOff);
	}

}
