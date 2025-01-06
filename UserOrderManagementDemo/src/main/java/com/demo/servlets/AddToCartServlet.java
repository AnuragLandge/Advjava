package com.demo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.CartItem;
import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String btn = request.getParameter("btn");
		switch (btn) {
		case "add" -> {
			HttpSession session = request.getSession();
			List<CartItem> clist = (List<CartItem>) session.getAttribute("cart");
			if (clist == null)
				clist = new ArrayList<>();
			String[] parr = request.getParameterValues("prod");
			ProductService pservice = new ProductServiceImpl();
			for (String id : parr) {
				Product p = pservice.getById(Integer.parseInt(id));
				int ordQty = Integer.parseInt(request.getParameter("p" + id));
				if (p.getQty() > ordQty) {
					CartItem c = new CartItem(p.getPid(), p.getPname(), ordQty, p.getPrice());
					clist.add(c);
				} else {
					CartItem c = new CartItem(p.getPid(), p.getPname(), ordQty, p.getPrice());
					clist.add(c);
				}
			}
			System.out.println(clist);
			session.setAttribute("cart", clist);
			RequestDispatcher rd = request.getRequestDispatcher("categories");
			rd.forward(request, response);
		}
		case "show" -> {
			RequestDispatcher rd = request.getRequestDispatcher("showcart.jsp");
			rd.forward(request, response);
		}
		}
	}

}
