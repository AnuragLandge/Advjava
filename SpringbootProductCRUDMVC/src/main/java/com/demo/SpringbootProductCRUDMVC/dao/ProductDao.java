package com.demo.SpringbootProductCRUDMVC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.SpringbootProductCRUDMVC.beans.Product1;

public interface ProductDao extends JpaRepository<Product1, Integer> {

}
