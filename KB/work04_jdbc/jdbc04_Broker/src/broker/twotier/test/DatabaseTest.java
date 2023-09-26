package broker.twotier.test;

import java.util.ArrayList;
import java.util.Vector;

import broker.twotier.dao.Database;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;

public class DatabaseTest {

	public static void main(String[] args)throws Exception{
		
		Database db = new Database("127.0.0.1");
		try {
//			db.addCustomer(new CustomerRec("777-777", "나나나", "군자동"));
//			db.deleteCustomer("888-888");
//			db.updateCustomer(new CustomerRec("666-888", "하바리1", "약수동1"));
			ArrayList<SharesRec> v = db.getPortfolio("999-999");
			for(SharesRec sr : v)System.out.println(v);
			ArrayList<CustomerRec> a = db.getAllCustomers();
			System.out.println(a);
			ArrayList<StockRec> h = db.getAllStocks();
			System.out.println(h);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}