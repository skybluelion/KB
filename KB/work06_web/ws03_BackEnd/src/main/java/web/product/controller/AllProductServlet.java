package web.product.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.product.model.Product;
import web.product.model.ProductDAOImpl;

@WebServlet("/AllProduct")
public class AllProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset-utf-8");

			//1. ProductDAOImpl 리턴 받아서
		
		try {
			ArrayList<Product> list=ProductDAOImpl.getInstance().findAllProducts();
			//2. 비지닛로직 호출...반환값 받고
			//3. Attribute에 바인딩			
			request.setAttribute("list", list);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

			//4. list.jsp 로페이지 이동
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

}