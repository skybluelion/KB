package com.jdbc.domain;
/*
 Customer 테이블의 정보를 저장하는 클래스
 Encapsulation 패턴으로 작성
 Customer 생성자 오버로딩
 */
public class Customer {
	private String ssn;
	private String name;
	private String address;
	public static final String BASIC_ADDR = "선릉";
	
	
	public Customer(String ssn, String name, String address) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}
	public Customer(String ssn) {
		this(ssn, "", BASIC_ADDR);
	}
	
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
	
	@Override
	public String toString() {
		return "Customer [ssn=" + ssn + ", name=" + name + ", address=" + address + "]";
	}
}
