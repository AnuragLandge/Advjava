package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Product;
import com.demo.service.ProductService;

public class TestProductJDBC {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		Scanner sc = new Scanner(System.in);
		ProductService pservice = (ProductService) ctx.getBean("productServiceImpl");
		int choice = 0;
		do {
			System.out.println("1. Add New Product\n2. Delete Product\n3. Modify Product");
			System.out.println("4. Display by Id\n5. Display All\n6. Display by Price in sorted order");
			System.out.println("7. Display Product less than price\n8. Exit\nEnter Your Choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1 -> pservice.addNewProduct();
			case 2 -> {
				System.out.println("Enter Id: ");
				int id = sc.nextInt();
				boolean status = pservice.deleteProduct(id);
				if (status)
					System.out.println("Product Deleted Successfully!");
				else
					System.out.println("Error Occured!");
			}
			case 3 -> {
				System.out.println("Enter Id: ");
				int id = sc.nextInt();
				boolean status = pservice.modifyProduct(id);
				if (status)
					System.out.println("Product Updated Successfully!");
				else
					System.out.println("Error Occured!");
			}
			case 4 -> {
				System.out.println("Enter Id: ");
				int id = sc.nextInt();
				Product p = pservice.displayById(id);
				if (p != null)
					System.out.println(p);
				else
					System.out.println("Error Occured!");
			}
			case 5 -> {
				List<Product> plist = pservice.displayAll();
				if (plist != null)
					plist.forEach(System.out::println);
				else
					System.out.println("Error Occured!");
			}
			case 6 -> {
				List<Product> plist = pservice.displaySortedByPrice();
				if (plist != null)
					plist.forEach(System.out::println);
				else
					System.out.println("Error Occured!");
			}
			case 7 -> {
				System.out.println("Enter Maximum Price: ");
				double price = sc.nextDouble();
				List<Product> plist = pservice.displayProductLessThanPrice(price);
				if (plist != null)
					plist.forEach(System.out::println);
				else
					System.out.println("Error Occured!");
			}
			case 8 -> {
				System.out.println("Thank You for Visiting!!");
				sc.close();
			}
			default -> System.out.println("Invalid Choice!!");
			}
		} while (choice != 8);
	}

}
