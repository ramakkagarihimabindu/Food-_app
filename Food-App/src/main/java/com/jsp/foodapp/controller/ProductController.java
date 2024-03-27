package com.jsp.foodapp.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.ProductDao;
import com.jsp.foodapp.entities.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/addproduct")
	public ModelAndView addAdmin()
	{
		ModelAndView mav=new ModelAndView("createproduct");
		Product p=new Product();
		mav.addObject("product",p);
		return mav;
	}
	@RequestMapping("/saveproduct")
	public ModelAndView saveProduct(@ModelAttribute("product") Product p)
	{
		ModelAndView mav=new ModelAndView("adminoptions");
		productDao.saveProduct(p);
		return mav;
	}
	@RequestMapping("/viewallproducts")
	public ModelAndView viewAllProducts()
	{
		List<Product> products=productDao.viewAllProducts();
		ModelAndView mav=new ModelAndView("allproducts");
		mav.addObject("productslist",products);
		return mav;
		
	}
	@RequestMapping("/editproduct")
	public ModelAndView editProduct(@RequestParam("id") int id)
	{
		Product p=productDao.viewProductById(id);
		ModelAndView mav=new ModelAndView("updateproduct");
		mav.addObject("productdata",p);
		return mav;
	}
	@RequestMapping("/updatedata")
	public ModelAndView updateProduct(ServletRequest req)
	{
		int id=(Integer.parseInt(req.getParameter("id")));
		String name=req.getParameter("name");
		String type=req.getParameter("type");
		Double cost=(Double.parseDouble(req.getParameter("cost")));
		Product p=new Product();
		p.setId(id);
		p.setName(name);
		p.setType(type);
		p.setCost(cost);
		
		productDao.updateProduct(p);
		ModelAndView mav=new ModelAndView("redirect:/viewallproducts");
		return mav;
	}
	@RequestMapping("/deleteproduct")
	public ModelAndView deleteProduct(@RequestParam("id") int id)
	{
		productDao.deleteProductById(id);
		ModelAndView mav=new ModelAndView("redirect:/viewallproducts");
		return mav;
	}
	@RequestMapping("/viewallproduct")
	public ModelAndView fetchAllProducts()
	{
		List<Product> products=productDao.viewAllProducts();
		ModelAndView mav=new ModelAndView("viewproducts");
		mav.addObject("productslist",products);
		return mav;
		
	}
	
}
