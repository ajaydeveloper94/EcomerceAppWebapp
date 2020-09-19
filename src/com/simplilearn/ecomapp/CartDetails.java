package com.simplilearn.ecomapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.hibernate.util.HibernateUtil2;
import com.simplilearn.model.Cart;
import com.simplilearn.model.Items;

/**
 * Servlet implementation class CartDetails
 */
@WebServlet("/add-to-cart")
public class CartDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartDetails() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// print writer
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
				
		// create cart
		Cart cart = new Cart();
		cart.setName("MyCart1");

		Items item1 = new Items(2, "Lenvo Laptop", 200000, cart);
		Items item2 = new Items(3, "DELL Laptop", 300000, cart);

		Set<Items> itemsSet = new HashSet<Items>();
		itemsSet.add(item1);
		itemsSet.add(item2);

		cart.setItems(itemsSet);

		//Get Session
		SessionFactory sFactory = HibernateUtil2.buildSessionFactory();
		Session session = sFactory.openSession();

		// start transaction
		Transaction tx = session.beginTransaction();
		// Save the Model object
		session.save(cart);
		session.save(item1);
		session.save(item2);
		// Commit transaction
		tx.commit();
		
		// Print Cart Details
		out.println("<h1>Cart  details :</h1>");
		out.println("<table>");
		out.println("<style> table, th, td { border: 1px solid black; padding: 15px;} </style>");
		out.println("<tr>");
		out.println("<th>"); out.println("Cart1 ID"); out.println("</th>");
		out.println("<th>"); out.println("Item1 Id"); out.println("</th>");
		out.println("<th>"); out.println("Item1 Name"); out.println("</th>");
		out.println("<th>"); out.println("Item2 Id"); out.println("</th>");
		out.println("<th>"); out.println("Item2 Name"); out.println("</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>"); out.println(cart.getId()); out.println("</td>");
		out.println("<td>"); out.println(item1.getItemId()); out.println("</td>");
		out.println("<td>"); out.println(item1.getItemName()); out.println("</td>");
		out.println("<td>"); out.println(item2.getItemId()); out.println("</td>");
		out.println("<td>"); out.println(item2.getItemName()); out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
