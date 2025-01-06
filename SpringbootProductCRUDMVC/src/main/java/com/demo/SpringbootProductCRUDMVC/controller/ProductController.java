package com.demo.SpringbootProductCRUDMVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.SpringbootProductCRUDMVC.beans.Product1;
import com.demo.SpringbootProductCRUDMVC.service.ProductService;

@Controller
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    ProductService pservice;

    @RequestMapping(value = "/show", method = RequestMethod.GET, produces = "application/json")
    public ModelAndView getAllProduct() {
        List<Product1> plist = pservice.getAllProducts();
        return new ModelAndView("showproducts", "plist", plist);
    }

    @RequestMapping(value = "/addnewproducts", method = RequestMethod.GET, produces = "application/json")
    public String addNewProducts(Model m1) {
        m1.addAttribute("u1", new Product1());
        return "insertproducts";
    }

    @RequestMapping(value = "/addproducts", method = RequestMethod.POST, produces = "application/json")
    public ModelAndView addProducts(@ModelAttribute Product1 p) {
        boolean status = pservice.insertProducts(p);
        if (status)
            return new ModelAndView("redirect:/products");
        else {
            String msg = "Error Occured! Please try again!";
            return new ModelAndView("login", "msg", msg);
        }
    }

    @RequestMapping(value = "/editproducts/{pid}", method = RequestMethod.GET, produces = "application/json")
    public ModelAndView editProduct(@PathVariable int pid) {
        Product1 p = pservice.getProductById(pid);
        if (p != null)
            return new ModelAndView("editproduct", "p", p);
        else
            return new ModelAndView("redirect:/products");
    }

    @RequestMapping(value = "/updateproducts", method = RequestMethod.POST, produces = "application/json")
    public ModelAndView updateProducts(@RequestParam int pid, @RequestParam String pname, @RequestParam int qty,
            @RequestParam double price) {
        Product1 p = new Product1(pid, pname, qty, price);
        boolean status = pservice.updateProduct(p);
        if (status)
            return new ModelAndView("redirect:/products");
        else {
            String msg = "Error Occured! Please try again!";
            return new ModelAndView("showproducts", "msg", msg);
        }
    }

    @RequestMapping(value = "/deleteproducts/{pid}", method = RequestMethod.DELETE, produces = "application/json")
    public ModelAndView deleteProductById(@PathVariable int pid) {
        boolean status = pservice.deleteProductById(pid);
        if (status)
            return new ModelAndView("redirect:/products");
        else {
            String msg = "Error Occured! Please try again!";
            return new ModelAndView("redirect:/products");
        }
    }
}
