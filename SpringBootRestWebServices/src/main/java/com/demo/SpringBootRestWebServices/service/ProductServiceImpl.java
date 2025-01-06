package com.demo.SpringBootRestWebServices.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringBootRestWebServices.beans.Product;
import com.demo.SpringBootRestWebServices.dao.ProductDao;
import com.demo.SpringBootRestWebServices.dto.ProductDto;
import com.demo.SpringBootRestWebServices.mapper.ProductDtoMapper;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao pdao;

	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> plist = pdao.findAll();
		List<ProductDto> plst = plist.stream().map(prod -> ProductDtoMapper.mapToProductDto(prod))
				.collect(Collectors.toList());
		return plst;
	}

	@Override
	public ProductDto getProductById(int pid) {
		Product p = pdao.findById(pid).orElse(null);
		if (p != null)
			return ProductDtoMapper.mapToProductDto(p);
		else
			return null;
	}

	@Override
	public boolean addNewProduct(ProductDto pdto) {
		Product p = ProductDtoMapper.mapToProduct(pdto);
		Product p1 = pdao.save(p);
		return p1 != null;
	}

	@Override
	public boolean updateProduct(int pid, ProductDto pdto) {
		Optional<Product> op = pdao.findById(pid);
		if (op.isPresent()) {
			Product p2 = op.get();
			p2.setPname(pdto.getPname());
			p2.setQty(pdto.getQty());
			p2.setPrice(pdto.getPrice());
			p2.setExpdate(LocalDate.parse(pdto.getExpdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			pdao.save(p2);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteById(int pid) {
		Optional<Product> op = pdao.findById(pid);
		if (op.isPresent()) {
			pdao.delete(op.get());
			return true;
		}
		return false;
	}
}
