package com.org.shopping.cart;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.org.shopping.item.EntertainmentItem;
import com.org.shopping.item.GeneralItem;
import com.org.shopping.item.Item;
import com.org.shopping.item.MedicalItem;

/**
 * @author prasanth
 * 
 * This class represents the junit methods to disply the items with cost.
 */
public class ShoppingCartTest {
	private ShoppingCart ShoppingCartTest = null;

	@Before
	public void setUp() throws Exception {
		ShoppingCartTest = new ShoppingCart();
	}

	@Test
	public void testProcessItemsScenarioOne() {
		List<Item> itemList = new ArrayList<>();
		System.out.println("Input :");

		itemList.add(new GeneralItem(1, "29.49", "Book"));
		itemList.add(new EntertainmentItem(1, "15.99", "music CD"));
		itemList.add(new GeneralItem(1, "0.75", "chocolate snack"));

		System.out.println();
		System.out.println("Output :");
		ShoppingCartTest.processItems(itemList);
	}

	@Test
	public void testProcessItemsScenarioTwo() {
		List<Item> itemList = new ArrayList<>();
		System.out.println("Input :");
		itemList.add(new GeneralItem(1, "20.99", "bottle of wine"));
		itemList.add(new MedicalItem(1, "4.15", "box of tooth ache pills"));
		itemList.add(new GeneralItem(1, "11.25", "box of pins"));
		itemList.add(new EntertainmentItem(1, "14.99", "music CD"));

		System.out.println();
		System.out.println("Output :");
		ShoppingCartTest.processItems(itemList);
		System.out.println();
		
	}
	
	@Test
	public void testProcessItemsForGeneralItem() {
		List<Item> itemList = new ArrayList<>();		
		itemList.add(new GeneralItem(1, "29.49", "Book"));
		ShoppingCartTest.processItems(itemList);
		GeneralItem generalItem = (GeneralItem)itemList.get(0);
		assertEquals(new BigDecimal("34.69"), generalItem.getMoney().getItemPrice());
		assertEquals(new BigDecimal("5.20"), generalItem.getMoney().getTaxAmount());
	}
	
	@Test
	public void testProcessItemsForEntertainmentItem() {
		List<Item> itemList = new ArrayList<>();		
		itemList.add(new EntertainmentItem(1, "14.99", "music CD"));
		ShoppingCartTest.processItems(itemList);
		EntertainmentItem entertainmentItem = (EntertainmentItem)itemList.get(0);
		assertEquals(new BigDecimal("18.89"), entertainmentItem.getMoney().getItemPrice());
		assertEquals(new BigDecimal("3.90"), entertainmentItem.getMoney().getTaxAmount());
	}
	
	@Test
	public void testProcessItemsForMedicalItem() {
		List<Item> itemList = new ArrayList<>();		
		itemList.add(new MedicalItem(1, "4.15", "box of tooth ache pills"));
		ShoppingCartTest.processItems(itemList);
		MedicalItem medicalItem = (MedicalItem)itemList.get(0);
		assertEquals(new BigDecimal("4.15"), medicalItem.getMoney().getItemPrice());
		assertEquals(new BigDecimal("0.00"), medicalItem.getMoney().getTaxAmount());
	}

}
