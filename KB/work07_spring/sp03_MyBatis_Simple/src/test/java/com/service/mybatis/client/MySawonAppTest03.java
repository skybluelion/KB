package com.service.mybatis.client;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.service.mybatis.vo.MySawon;

import util.FactoryService;

public class MySawonAppTest03 {

	public static void main(String[] args) throws Exception {
		SqlSessionFactory factory = FactoryService.getFactory();

		//3. SqlSession 생성
		SqlSession session = factory.openSession();
		System.out.println("SqlSession Creating....");

		//4. 
		List<MySawon> list = session.selectList("sawonMapper.sawonList");
		for (MySawon v : list) {
			System.out.println(v);
		}
	}
}