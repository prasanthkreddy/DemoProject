package com.org.shopping.cart;

import java.math.BigDecimal;
import java.util.List;

import com.org.shopping.item.EntertainmentItem;
import com.org.shopping.item.GeneralItem;
import com.org.shopping.item.Item;
import com.org.shopping.item.MedicalItem;
import com.org.shopping.visitor.Visitor;
import com.org.shopping.visitor.VisitorImpl;

/**
 * @author prasanth
 * This class processess the final price and tax calculations for given list of items.
 */
public class ShoppingCart {

	BigDecimal totalPrice = new BigDecimal(0.);
	BigDecimal totalTax = new BigDecimal(0.);

	public void processItems(List<Item> itemList) {
		Visitor visitor = new VisitorImpl();
		if (!itemList.isEmpty()) {
			for (Item item : itemList) {
				Item resultItem = item.accept(visitor);
				printItems(resultItem);
			}
			System.out.println("Sales Taxes : " + totalTax);
			System.out.println("Total : " + totalPrice);
			System.out.println();
		}
	}

	public void printItems(Item item) {
		if (item instanceof GeneralItem) {
			GeneralItem generalItem = (GeneralItem) item;
			BigDecimal itemPrice = generalItem.getMoney().getItemPrice();
			BigDecimal quantity = new BigDecimal(generalItem.getQty());
			totalPrice = totalPrice.add(itemPrice).multiply(quantity);
			totalTax = totalTax.add(generalItem.getMoney().getTaxAmount()).multiply(quantity);
			System.out.println(generalItem.getQty() + " " + generalItem.getItemType() + " : " + itemPrice.multiply(quantity));
		} else if (item instanceof EntertainmentItem) {
			EntertainmentItem entertainmentItem = (EntertainmentItem) item;
			BigDecimal itemPrice = entertainmentItem.getMoney().getItemPrice();
			BigDecimal quantity = new BigDecimal(entertainmentItem.getQty());
			totalPrice = totalPrice.add(itemPrice).multiply(quantity);
			totalTax = totalTax.add(entertainmentItem.getMoney().getTaxAmount()).multiply(quantity);
			System.out.println(entertainmentItem.getQty() + " " + entertainmentItem.getItemType() + " : " + itemPrice.multiply(quantity));
		} else if (item instanceof MedicalItem) {
			MedicalItem medicalItem = (MedicalItem) item;
			BigDecimal itemPrice = medicalItem.getMoney().getItemPrice();
			BigDecimal quantity = new BigDecimal(medicalItem.getQty());
			totalPrice = totalPrice.add(itemPrice).multiply(quantity);
			totalTax = totalTax.add(medicalItem.getMoney().getTaxAmount()).multiply(quantity);
			System.out.println(medicalItem.getQty() + " " + medicalItem.getItemType() + " : " + itemPrice.multiply(quantity));
		}
	}

}
