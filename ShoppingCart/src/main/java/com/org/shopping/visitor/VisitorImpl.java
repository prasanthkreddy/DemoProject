package com.org.shopping.visitor;

import java.math.BigDecimal;

import com.org.shopping.item.EntertainmentItem;
import com.org.shopping.item.GeneralItem;
import com.org.shopping.item.Item;
import com.org.shopping.item.MedicalItem;
import com.org.shopping.item.Money;
import com.org.tax.util.TaxCalculator;


/**
 * @author prasanth 
 * 
 * This class represents the implementation for the visitor pattern
 */
public class VisitorImpl implements Visitor {

	@Override
	public Item visit(GeneralItem item) {
		BigDecimal itemValue = new BigDecimal(item.getPrice());
		BigDecimal totalTax = TaxCalculator.calculateTax(itemValue);
		BigDecimal finalPrice = itemValue.add(totalTax).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		Money money = new Money();
		money.setItemPrice(finalPrice);
		money.setTaxAmount(finalPrice.subtract(itemValue));
		item.setMoney(money);
		return item;
	}

	@Override
	public Item visit(EntertainmentItem item) {
		BigDecimal itemValue = new BigDecimal(item.getPrice());
		BigDecimal totalTax = TaxCalculator.calculateTaxWithAdditionalCharges(itemValue);
		BigDecimal finalPrice = itemValue.add(totalTax).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		Money money = new Money();
		money.setItemPrice(finalPrice);
		money.setTaxAmount(finalPrice.subtract(itemValue));
		item.setMoney(money);
		return item;
	}

	@Override
	public Item visit(MedicalItem item) {
		BigDecimal itemValue = new BigDecimal(item.getPrice());
		BigDecimal totalTax = new BigDecimal(0.);
		BigDecimal finalPrice = itemValue.add(totalTax).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		Money money = new Money();
		money.setItemPrice(finalPrice);
		money.setTaxAmount(finalPrice.subtract(itemValue));
		item.setMoney(money);
		return item;
	}
}
