package com.jsp.foodapp.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.UserDao;
import com.jsp.foodapp.entities.User;

@Controller
public class UserController {
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/adduser")
	public ModelAndView addUser()
	{
		ModelAndView mav=new ModelAndView("createuser");
		User user=new User();
		mav.addObject("user",user);
		return mav;
	}
	@RequestMapping("/saveuser")
	public ModelAndView saveUser(@ModelAttribute("user") User u)
	{
		ModelAndView mav=new ModelAndView("loginuser");
		userDao.saveUser(u);
		return mav;
	}
	@RequestMapping("/validateuser")
	public ModelAndView logInValidation(ServletRequest req,HttpSession session)
	{
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		User user=userDao.login(email, password);
		if(user==null)
		{
			ModelAndView mav=new ModelAndView("loginuser");
			mav.addObject("message","invalid credentials");
			return mav;
		}
		else
		{
			ModelAndView mav=new ModelAndView("useroptions");
			session.setAttribute("user",user);
			return mav;
		}
	}

}
