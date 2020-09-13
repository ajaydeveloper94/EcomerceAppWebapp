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

import com.simplilearn.hibernate.util.HibernateUtil;
import com.simplilearn.hibernate.util.HibernateUtil2;
import com.simplilearn.model.EProduct;
import com.simplilearn.model.Items;

/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/items-details")
public class ItemsDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemsDetails() { }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// print writer
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		//open a connection
		try {
			SessionFactory sFactory = HibernateUtil2.buildSessionFactory();
			Session session = sFactory.openSession();
			session.beginTransaction();
			
			List<Items> items = session.createQuery("from Items").list();
			
			// Print Porducts
			out.println("<h1>Items details :</h1>");
			
			for(Items i:items) {
				out.println("<br> <p>Id :-> " + i.getItemId() +" , Name :-> "+i.getItemName() +" ,Quantity :-> "+i.getQuantity() +" , Total Price :-> "+i.getTotalPrice() +"</p>");
			}
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
