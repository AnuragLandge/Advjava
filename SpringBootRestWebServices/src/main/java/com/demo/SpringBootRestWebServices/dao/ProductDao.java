package com.demo.SpringBootRestWebServices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.SpringBootRestWebServices.beans.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
