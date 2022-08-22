package com.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.servlet.ModelAndView;

import com.Bean.Cart;
import com.Bean.Customer;
import com.Bean.Item;
import com.Bean.Transaction_Details;
import com.Service.allitemService;
import com.Service.generate_billService;
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
	
	@Autowired
	private generate_billService gbs;
	
	@ModelAttribute("item_Ids")
	public List<Integer> getItem_Ids(){
		List<Item> items=allitemService.showallitem();
		
		return items.stream()
				.map(Item::getItem_ID)
				.distinct().sorted().collect(Collectors.toList());
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
	
	
	
	
	@RequestMapping("/GenerateBill")
	public ModelAndView generateBillController(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		session.setAttribute("customer", customer);
		
       String user_name = customer.getUser_Name();
		
	
		int customerId = customerService.searchCustomerID(user_name);
		List<Cart> cart = gbs.generate_bill(customerId);

		double total=gbs.total_bill(customerId);
		
		String message="Total :"+total;
		modelAndView.addObject("message", message);
		//modelAndView.setViewName("Output");
		modelAndView.addObject("itemList", cart);
			
			modelAndView.setViewName("GenerateBill");
		
		return  modelAndView;

	}
	
	@RequestMapping("/updateQuantity")
	public ModelAndView updateQuantityController() {
		return new ModelAndView("UpdateQuantity");
		
	}
	
	@RequestMapping("/quantityUpdated")
	public ModelAndView quantityUpdated(HttpServletRequest request) {
		String item_id=request.getParameter("item_id");
		String quantity=request.getParameter("quantity");
		boolean res = transactionDetailsService.updateitemquantity(Integer.parseInt(item_id),Integer.parseInt(quantity));
		ModelAndView modelAndView = new ModelAndView();
		if (res==true){
			String message = "Now you are purchasing "+quantity+ " quantity for Item Id "+item_id;
			modelAndView.addObject("message",message);
		}
		else {
			String message = "Quantity not Updated\nSomething went wrong";
			modelAndView.addObject("message",message);
		}
		
		modelAndView.setViewName("Output");
		return modelAndView;
	}

}
