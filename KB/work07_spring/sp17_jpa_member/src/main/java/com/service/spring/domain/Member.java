package com.service.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//vo의 정보를 table과 Mapping :: ORM Object table Relation Mapping

@Entity
@Table(name="member")
public class Member {
	@Id
	@Column(name="id")
	private String id; //pk @Id
	
	@Column(nullable = false)
	private String password; //기본값 true
	
	@Column(length = 30, nullable = false)
	private String name;
	
	@Column(length = 100)
	private String address;

	public Member(String id, String password, String name, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
	}

	public Member() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
}
