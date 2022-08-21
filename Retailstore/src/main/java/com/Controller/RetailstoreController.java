package com.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.servlet.ModelAndView;

import com.Bean.Cart;
import com.Bean.Customer;
import com.Bean.Item;
import com.Bean.Transaction_Details;
//import com.Controller.LoginController.User;
import com.Service.allitemService;
import com.Service.customerService;
import com.Service.transactionDetailsService;

@Controller
@Scope("session")
@SessionAttributes("customer")
public class RetailstoreController {
	
	@Autowired
	private Customer customer;
	
	@Autowired
	private customerService customerService;
	
	@Autowired
	private allitemService allitemService;
	
	@Autowired
	private transactionDetailsService transactionDetailsService;
	
	@ModelAttribute("item_Ids")
	public List<Integer> getItem_Ids(){
		List<Item> items=allitemService.showallitem();
		
		return items.stream()
				.map(Item::getItem_ID)
				.distinct().sorted().toList();
	}
	
	@RequestMapping("/menu")
	public ModelAndView mainPageController() {
		return new ModelAndView("index");
	}
	
	
	@RequestMapping("/ShowAllItems")
	public ModelAndView showAllItemsController() {

		List<Item> items = allitemService.showallitem();

		return new ModelAndView("ShowAllItems", "itemList", items);

	}
	
	@RequestMapping("/Cart")
	public ModelAndView cartController() {
		return new ModelAndView("Cart");
	}
	
	@RequestMapping("/Logout")
	public ModelAndView logoutController() {
		return new ModelAndView("Login", "command", new Customer());
	}
	
	@RequestMapping("/AddtoCart")
	public ModelAndView addtoCartController() {
		
		List<Item> items = allitemService.showallitem();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList", items);
		modelAndView.addObject("newTrans", new Transaction_Details());
		
		modelAndView.setViewName("AddtoCart");

		return modelAndView;
		
	}
	
	@RequestMapping("/saveItem")
	public ModelAndView saveItemController(@ModelAttribute("newTrans") Transaction_Details transaction_Details, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		
		HttpSession session = request.getSession();
		session.setAttribute("customer", customer);
		
		int item_id = transaction_Details.getItem_ID();
		//System.out.println("item id : ------------"+item_id);
		int quantity = transaction_Details.getQuantity();
		//System.out.println(quantity);
		
		String user_name = customer.getUser_Name();
		
		int customerId = customerService.searchCustomerID(user_name);
		
		System.out.println("======================+++++++++");
		
		Item item = allitemService.searchItem(item_id);
		System.out.println(item + "======================");
		
		
		Cart cart = new Cart();		
		
		cart.setCustomer_id(customerId);
		cart.setItem_Id(item_id);
		cart.setItem_Name(item.getItem_Name());
		cart.setQuantity(quantity);
		cart.setPrice(item.getItem_Price());
				

		String message = null;
		
		if (transactionDetailsService.addToCart(cart))
			message = "Item Addded Successfully";
		else
			message = "Item Addition Failed";

		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");

		return modelAndView;
	}

}
