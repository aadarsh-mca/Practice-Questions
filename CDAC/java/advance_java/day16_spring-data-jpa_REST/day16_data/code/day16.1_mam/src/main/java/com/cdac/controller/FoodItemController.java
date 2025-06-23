package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.dao.FoodItemDao;
import com.cdac.service.FoodItemService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/food_items")
public class FoodItemController {

    private final FoodItemDao foodItemDao;
	// add depcy
	@Autowired // byType
	private FoodItemService foodItemService;

	public FoodItemController(FoodItemDao foodItemDao) {
		System.out.println("in ctor " + getClass());
		this.foodItemDao = foodItemDao;
	}

	// http://localhost:8080/spring_mvc/food_items/update?id=13
	// method- GET
	/*
	 * Add rq handling method to render update form
	 */
	@GetMapping("/update")
	public String renderUpdateForm(@RequestParam Long id, 
			Model map) {
		System.out.println("in render update form " + id);
		// get food item details by its id from the service layer
		map.addAttribute("food_item", 
				foodItemService.getFoodItemDetails(id));
		return "food_items/update";//Handler -> D.S -> V.R -> AVN 
		// /WEB-INF/views/food_items/update.jsp
	}
	/*
	 * Add a req handling method - to process update form
	 * URL - http://localhost:8080/spring_mvc/food_items/update?id=13
	 * Method - POST
	 */
	@PostMapping("/update")
	public String processUpdateForm(@RequestParam Long id,
			@RequestParam String desc,@RequestParam double price,HttpSession hs) {
	  System.out.println("in process update "+id +" "+desc+" "+price);
	  //get rest id from session scope
	  Long restId=(Long) hs.getAttribute("restaurant_id");
	  //invoke service method
	  String mesg=foodItemService.updateFoodItemDetails(id,desc,price);
	  return "redirect:/restaurants/details?restaurant_id="+restId;
			  //"redirect:/restaurants/list";
	  /*
	   * SC auto calls - response.sendRedirect(
	   * response.encodeRedirectURL("restaurants/list);
	   */
	}
	

}
