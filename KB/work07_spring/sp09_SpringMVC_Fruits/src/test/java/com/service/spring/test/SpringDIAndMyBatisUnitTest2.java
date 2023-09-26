package com.service.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.domain.Item;
import com.service.spring.service.ItemCatalog;

public class SpringDIAndMyBatisUnitTest2 {

	public static void main(String[] args) throws Exception {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("/beans/bean.xml");
		
		ItemCatalog service = (ItemCatalog)factory.getBean("itemCatalogImpl");
		System.out.println("==========getListItem================");
		List<Item> list=service.getItemList();
		for (Item vo : list) {
			System.out.println(vo);
		}
		
		System.out.println("==========getList===================");
		Item item = service.getItem(1111);
		System.out.println(item);
	}

}
