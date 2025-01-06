package com.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.MyUser;
import com.demo.beans.Product;
import com.demo.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService pservice;

	@GetMapping("/products")
	public ModelAndView getAllProduct(HttpSession session) {
		MyUser user = (MyUser) session.getAttribute("user");
		if (user != null && user.getRole().equals("admin")) {
			List<Product> plist = pservice.getAllProduct();
			return new ModelAndView("showproducts", "plist", plist);
		} else {
			String msg = "Please Login to Application First!";
			return new ModelAndView("login", "msg", msg);
		}
	}

	@GetMapping("/addnewproducts")
	public String addNewProducts(Model m1, HttpSession session) {
		MyUser user = (MyUser) session.getAttribute("user");
		if (user != null && user.getRole().equals("admin")) {
			m1.addAttribute("u1", new Product());
			return "insertproducts";
		} else {
			return "login";
		}
	}

	@PostMapping("/addproducts")
	public ModelAndView addProducts(@ModelAttribute Product p, HttpSession session) {
		MyUser user = (MyUser) session.getAttribute("user");
		if (user != null && user.getRole().equals("admin")) {
			boolean status = pservice.insertProducts(p);
			if (status)
				return new ModelAndView("redirect:/product/products");
			else {
				String msg = "Error Occured! Please try again!";
				return new ModelAndView("login", "msg", msg);
			}
		} else {
			String msg = "Please login to application first!";
			return new ModelAndView("login", "msg", msg);
		}
	}

	@GetMapping("/editproducts/{pid}")
	public ModelAndView editProduct(@PathVariable int pid, HttpSession session) {
		MyUser user = (MyUser) session.getAttribute("user");
		if (user != null && user.getRole().equals("admin")) {
			Product p = pservice.getById(pid);
			if (p != null)
				return new ModelAndView("editproduct", "p", p);
			else {
				return new ModelAndView("redirect:/product/getproducts");
			}
		} else {
			String msg = "Please login to application first!";
			return new ModelAndView("login", "msg", msg);
		}
	}

	@PostMapping("/updateproducts")
	public ModelAndView updateProducts(HttpSession session, @RequestParam int pid, @RequestParam String pname,
			@RequestParam int qty, @RequestParam double price, @RequestParam String expdate, @RequestParam int cid) {
		MyUser user = (MyUser) session.getAttribute("user");
		if (user != null && user.getRole().equals("admin")) {
			LocalDate date = LocalDate.parse(expdate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Product p = new Product(pid, pname, qty, price, date, cid);
			boolean status = pservice.updateProduct(p);
			if (status)
				return new ModelAndView("redirect:/product/products");
			else {
				String msg = "Error Occured! Please try again!";
				return new ModelAndView("showproducts", "msg", msg);
			}
		} else {
			String msg = "Please login to application first!";
			return new ModelAndView("login", "msg", msg);
		}
	}

	@GetMapping("deleteproducts/{pid}")
	public ModelAndView deleteProducts(@PathVariable int pid, HttpSession session) {
		MyUser user = (MyUser) session.getAttribute("user");
		if (user != null && user.getRole().equals("admin")) {
			boolean status = pservice.deleteProduct(pid);
			if (status)
				return new ModelAndView("redirect:/product/products");
			else {
				String msg = "Error Occured! Please try again!";
				return new ModelAndView("showproducts", "msg", msg);
			}

		} else {
			String msg = "Please login to application first!";
			return new ModelAndView("login", "msg", msg);
		}
	}

}
