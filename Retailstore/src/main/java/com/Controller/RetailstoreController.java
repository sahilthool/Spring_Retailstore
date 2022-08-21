package com.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Bean.Cart;
import com.Bean.Customer;
import com.Bean.Item;
import com.Bean.Transaction_Details;
//import com.Controller.LoginController.User;
import com.Service.allitemService;
import com.Service.transactionDetailsService;

@Controller
public class RetailstoreController {
	
//	@Autowired
//	private User user;
	
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
		return new ModelAndView("AddtoCart", "newTrans", new Transaction_Details());
	}
	
	@RequestMapping("/saveItem")
	public ModelAndView saveItemController(@ModelAttribute("newTrans") Transaction_Details transaction_Details, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		
		int item_id = transaction_Details.getItem_ID();
		int quantity = transaction_Details.getQuantity();
		
		Cart cart = new Cart();
		
		cart.setCustomer_id(1);
		cart.setItem_Id(item_id);
		cart.setItem_Name(allitemService.searchItem(item_id).getItem_Name());
		cart.setQuantity(quantity);
		cart.setPrice(allitemService.searchItem(item_id).getItem_Price());
				

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
