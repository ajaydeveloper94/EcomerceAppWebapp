package com.simplilearn.ecomapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.hibernate.util.HibernateUtil;
import com.simplilearn.model.EProduct;

/**
 * Servlet implementation class AddProdct
 */
@WebServlet("/add-product")
public class AddProdct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProdct() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("add-product.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// print writer
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		// read product etails
		String pname = request.getParameter("name");
		String price = request.getParameter("price");
		
		// open a connection
		try {
			SessionFactory sFactory = HibernateUtil.buildSessionFactory();
			Session session = sFactory.openSession();
			Transaction trans = session.beginTransaction();

			EProduct product = new EProduct();
			product.setName(pname);
			product.setPrice(Double.valueOf(price));
			
			session.save(product);
			
			//7. commit transaction
	    	trans.commit();
			
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
