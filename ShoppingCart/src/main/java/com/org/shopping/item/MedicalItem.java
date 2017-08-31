package com.org.shopping.item;

import com.org.shopping.visitor.Visitor;

public class MedicalItem implements Item {

	private String itemType;
	private int qty;
	private String price;
	private Money money;

	public MedicalItem(int qty, String price, String itemType) {
		this.qty = qty;
		this.price = price;
		this.itemType = itemType;
		System.out.println(qty + " " + itemType + " : " + price);
	}

	public int getQty() {
		return qty;
	}

	public String getPrice() {
		return price;
	}

	public String getItemType() {
		return itemType;
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}
	
	public String toString() {
		return qty + " " + itemType + " : " + price;
	};

	@Override
	public Item accept(Visitor visitor) {
		return visitor.visit(this);
	}

}
