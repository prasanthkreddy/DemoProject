package com.org.shopping.visitor;

import com.org.shopping.item.EntertainmentItem;
import com.org.shopping.item.GeneralItem;
import com.org.shopping.item.Item;
import com.org.shopping.item.MedicalItem;

public interface Visitor {

	Item visit(GeneralItem genItem);
	Item visit(EntertainmentItem entItem);
	Item visit(MedicalItem medItem);
}
