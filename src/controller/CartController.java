package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import java.util.*;
import entities.*;
import model.*;


/**
 * Servlet implementation class CartController
 */
@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action == null) {
			request.getRequestDispatcher("cart/index.jsp").forward(request, response);
		} else if(action.equalsIgnoreCase("buy")) {
			doGet_Buy(request, response);
		} else if (action.equalsIgnoreCase("delete")) {
			doGet_Delete(request, response);
		} else if(action.equalsIgnoreCase("checkout")) {
			doGet_CheckOut(request, response);
		}
	}
	
	protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prId = Integer.parseInt(request.getParameter("prId"));
		ProductRestClient productRestClient = new ProductRestClient();
		ProductWS productWS = productRestClient.find(prId);
		HttpSession session = request.getSession();
		if(session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(productWS, 1));
			session.setAttribute("cart", cart);
		}else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = isExist(cart, prId);
			if(index == -1) {
				cart.add(new Item(productWS, 1));
			}else {
				int qty = cart.get(index).getQty() + 1;
				cart.get(index).setQty(qty);
			}
			session.setAttribute("cart", cart);
		}
		response.sendRedirect("cart");
	}
	
	protected void doGet_CheckOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		OrderRestClient orderRestClient = new OrderRestClient();
		CartitemsRestClient cartitemsRestClient = new CartitemsRestClient();
		//Add orders
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CusorderWS cusorderWS = new CusorderWS();
		cusorderWS.setBillDate(simpleDateFormat.());
		cusorderWS.setOrderId(orderId);
		int cartId = Integer.parseInt(orderRestClient.create(cusorderWS));
		//add order details
		
		for(Item item : cart) {
			CartitemsWS cartitemsWS = new CartitemsWS();
			cartitemsWS.setCartId(cartId);
			cartitemsWS.setPrice(item.getProductWS().getPrice());
			cartitemsWS.setItemId(item.getProductWS().getItemId());
			cartitemsWS.setProductId(item.getProductId());
			cartitemsWS.setQty(item.getQty());
			cartitemsRestClient.create(cartitemsWS);			
		}
		//remove cart
		session.removeAttribute("cart");
	}
	
	
	
	protected void doGet_Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int index = Integer.parseInt(request.getParameter("index"));
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		cart.remove(index);
		session.setAttribute("cart", cart);
		response.sendRedirect("cart");
	}
	
	private int isExist(List<Item> cart, int prId) {
		for (int i=0; i<cart.size(); i++) {
			if(cart.get(i).getProductWS().getId() == prId) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
