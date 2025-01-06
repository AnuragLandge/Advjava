package com.demo.SpringBootRestWebServices.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.demo.SpringBootRestWebServices.beans.Product;
import com.demo.SpringBootRestWebServices.dto.ProductDto;

public class ProductDtoMapper {
	public static ProductDto mapToProductDto(Product p) {
		return new ProductDto(p.getPid(), p.getPname(), p.getQty(), p.getPrice(),
				p.getExpdate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), p.getCid());
	}

	public static Product mapToProduct(ProductDto pdto) {
		return new Product(pdto.getPid(), pdto.getPname(), pdto.getQty(), pdto.getPrice(),
				LocalDate.parse(pdto.getExpdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")), pdto.getCid());
	}
}
