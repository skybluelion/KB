package broker.twotier.vo;
/*
 * 주식을 보유하는 고객에 대한 정보를 담는 클래스...
 * 고객== 주식을 보유하지 않는 고객 + 현재 주식을 보유하고 있는 고객
 */

import java.util.ArrayList;


public class CustomerRec {
	private String ssn;
	private String name; //컬럼명은 cust_name 필드랑 DB값이랑 다를 수 있음! DB 전문가와 개발자간에 코드값이 다름.
	private String address;
	
	//추가...
	private ArrayList<SharesRec> portfolio; // 현업에서는 join을 많이 써서 코드가 복잡함.이렇게 설계하도록 유도
	//1대다에서 주식정보 여러개 포함시킬때 이런 식으로 삽입, 예를 들면 국민 8주, 삼성 100주 이런식의 타입

	public CustomerRec(String ssn, String name, String address, ArrayList<SharesRec> portfolio) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
		this.portfolio = portfolio;
	}

	public CustomerRec(String ssn, String name, String address) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}

	public CustomerRec() {	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<SharesRec> getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(ArrayList<SharesRec> portfolio) {
		this.portfolio = portfolio;
	}

	@Override
	public String toString() {
		return "CustomerRec [ssn=" + ssn + ", name=" + name + ", address=" + address + ", portfolio=" + portfolio + "]";
	}
	
}










