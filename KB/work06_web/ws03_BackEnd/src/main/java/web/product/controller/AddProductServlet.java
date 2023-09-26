package web.product.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.product.model.Product;
import web.product.model.ProductDAOImpl;

@WebServlet("/AddProduct")
public class AddProductServlet extends HttpServlet {
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
			//1. 폼값 받아서
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		
			//2. vo객체 생성
		Product pvo = new Product(name, price, description);
		
			//3. ProductDAOImpl 리턴받아서
		
		try {
			int id = ProductDAOImpl.getInstance().AddPrdouct(pvo);
			//4. 비지니스로직 호출
			//5. Attribute에 바인딩		
			request.setAttribute("id", id);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

			//6. register_result.jsp로 페이지이동
//		response.sendRedirect("register_result.jsp");
		request.getRequestDispatcher("register_result.jsp").forward(request, response);
	}

}
