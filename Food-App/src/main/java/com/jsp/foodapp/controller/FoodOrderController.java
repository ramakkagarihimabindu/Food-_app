package com.jsp.foodapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.FoodOrderDao;
import com.jsp.foodapp.dao.UserDao;
import com.jsp.foodapp.entities.FoodOrder;
import com.jsp.foodapp.entities.Item;
import com.jsp.foodapp.entities.User;


@Controller
public class FoodOrderController {
	
	@Autowired
	FoodOrderDao foodOrderDao;
	
	double totalbill=0;
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/createorder")
	public ModelAndView createOrder()
	{
		ModelAndView mav=new ModelAndView("createfoodorder");
		FoodOrder foodOrder=new FoodOrder();
		mav.addObject("foodorder", foodOrder);
		return mav;
	}
	@RequestMapping("/savefoodorder")
	public ModelAndView saveFoodOrder(@ModelAttribute("foodorder") FoodOrder foodOrder,HttpSession session)
	{
		session.setAttribute("userfoodorder", foodOrder);
		ModelAndView mav=new ModelAndView("redirect:/viewallproduct");
		return mav;
	}
	@RequestMapping("/submitfoodorder")
	public ModelAndView submitFoodOrder(HttpSession session)
	{
		FoodOrder foodOrder=(FoodOrder)session.getAttribute("userfoodorder");
		List<Item> items=(List<Item>)session.getAttribute("itemsList");
		foodOrder.setItems(items);
		
		
		items.stream().forEach(i->
		{
			totalbill = totalbill+i.getCost();
		});
		foodOrder.setTotalbill(totalbill);

		User u = (User) session.getAttribute("user");
		List<FoodOrder> orders = u.getOrders();
		if (orders.size() > 0) {
			orders.add(foodOrder);
			foodOrder.setUser(u);
			u.setOrders(orders);
		} else {
			List<FoodOrder> orders1 = new ArrayList<FoodOrder>();
			orders1.add(foodOrder);
			foodOrder.setUser(u);
			u.setOrders(orders1);
		}
		foodOrderDao.saveFoodOrder(foodOrder);
		userDao.updateUser(u);

		ModelAndView mav = new ModelAndView("useroptions");
		return mav;
	}
}
