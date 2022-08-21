package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Bean.Item;
import com.Service.allitemService;

@Controller
public class RetailstoreController {
	
	@Autowired
	private allitemService allitemService;
	
	@RequestMapping("/menu")
	public ModelAndView mainPageController() {
		return new ModelAndView("index");
	}
	
	
	@RequestMapping("/ShowAllItems")
	public ModelAndView showAllItemsController() {

		List<Item> items = allitemService.showallitem();

		return new ModelAndView("ShowAllItems", "itemList", items);

	}
	

}
