package com.org.shopping.item;

import com.org.shopping.visitor.Visitor;

public interface Item {

	public Item accept(Visitor visitor);

}
