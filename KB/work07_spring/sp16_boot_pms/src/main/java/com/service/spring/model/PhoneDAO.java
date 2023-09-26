package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;

//mapping.xml 아이디가 함수명으로..
public interface PhoneDAO {
	int insert(Phone phone);
	int delete(List<String> list);
	List<Phone> select();
	Phone select(Phone phone);
	UserInfo select(UserInfo user); //overloading/ selectUser를 안쓰고 select로
}
