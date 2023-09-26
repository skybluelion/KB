package com.service.spring.dao;

import java.util.List;

import com.service.spring.domain.Item;

//~mapping.xml 쿼리문 id값이 메소드의 이름으로
public interface ItemDAO {
	List<Item> getItemList() throws Exception;
	Item getItem(Integer itemid) throws Exception;
}
