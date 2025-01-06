package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestMyCrudHibernateDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		ProductService pservice = new ProductServiceImpl();
		do {

			System.out.println("1. Add new Product\n2. Display all products\n3. Delete by id\n4. Update by id");
			System.out.println("5. Display by id\n 6. Sort by name\n7.Exit\n Enter Your Choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1 -> {
				pservice.addNewProduct();

			}
			case 2 -> {
				List<Product> plist = pservice.displayAll();
				if (plist != null) {
					plist.forEach(System.out::println);
				} else {
					System.out.println("Table is Empty!!");
				}
			}
			case 3 -> {
				System.out.println("Enter Product Id:");
				int pid = sc.nextInt();
				boolean status = pservice.deleteById(pid);
				if (status) {
					System.out.println("Product Deleted Successfully!!");
				} else {
					System.out.println("Error occur!!");
				}

			}
			case 4 -> {
				System.out.println("Enter Product Id: ");
				int pid = sc.nextInt();
				System.out.println("Enter New Product Quantity: ");
				int qty = sc.nextInt();
				System.out.println("Enter New Product Price: ");
				double price = sc.nextDouble();
				boolean status = pservice.updateById(pid, qty, price);
				if (status) {
					System.out.println("Product Updated Successfully!!");
				} else {
					System.out.println("Error occur!!");
				}

			}
			case 5 -> {
				System.out.println("Enter Product Id:");
				int pid = sc.nextInt();
				Product p = pservice.displayById(pid);
				if (p != null)
					System.out.println(p);
				else
					System.out.println("Not Found");
			}
			case 6 -> {
				List<Product> plist = pservice.sortByName();
				if(plist!=null) {
					plist.forEach(System.out::println);
				}else {
					System.out.println("Table is empty!");
				}
			}
			case 7 -> {
				System.out.println("Thank u for visiting!!");
				sc.close();
				pservice.closeConnection();
			}
			default -> System.out.println("Invalid Choice!1");
			}
		} while (choice != 7);
	}

}
