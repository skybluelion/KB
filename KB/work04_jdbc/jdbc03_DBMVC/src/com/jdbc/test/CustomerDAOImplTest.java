package com.jdbc.test;

import java.util.ArrayList;

import com.jdbc.dao.CustomerDAOImpl;
import com.jdbc.domain.Customer;

public class CustomerDAOImplTest {

	public static void main(String[] args) {
		CustomerDAOImpl dao = CustomerDAOImpl.getInstance();
		try {
//			dao.registerCustomer(new Customer("111", "제임스", "보스턴"));
//			dao.updateCustomer(new Customer("333", "제임스", "서울"));
			dao.getCustomer();
			ArrayList<Customer> list = dao.getCustomer();
			for(Customer c : list) System.out.println(c);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
