package com.org.shopping.visitor;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.org.shopping.item.EntertainmentItem;
import com.org.shopping.item.GeneralItem;
import com.org.shopping.item.MedicalItem;

public class VisitorImplTest {
	
	private Visitor visitor = null;

	@Before
	public void setUp() throws Exception {
		visitor = new VisitorImpl();
	}

	@Test
	public void testVisitForGeneralItem() {
		GeneralItem item = new GeneralItem(1, "29.49", "Book");
		visitor.visit(item);
		assertEquals(new BigDecimal("34.69"), item.getMoney().getItemPrice());
		assertEquals(new BigDecimal("5.20"), item.getMoney().getTaxAmount());
	}

	@Test
	public void testVisitForEntertainmentItem() {
		EntertainmentItem item = new EntertainmentItem(1, "14.99", "music CD");
		visitor.visit(item);
		assertEquals(new BigDecimal("18.89"), item.getMoney().getItemPrice());
		assertEquals(new BigDecimal("3.90"), item.getMoney().getTaxAmount());
	}
	
	@Test
	public void testVisitForMedicalItem() {
		MedicalItem item = new MedicalItem(1, "4.15", "box of tooth ache pills");
		visitor.visit(item);
		assertEquals(new BigDecimal("4.15"), item.getMoney().getItemPrice());
		assertEquals(new BigDecimal("0.00"), item.getMoney().getTaxAmount());
	}
}
