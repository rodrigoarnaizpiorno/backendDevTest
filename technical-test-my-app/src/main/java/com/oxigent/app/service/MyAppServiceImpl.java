package com.oxigent.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oxigent.app.mockapi.model.MockProduct;
import com.oxigent.app.mockapi.service.MockService;
import com.oxigent.app.model.Product;

@Service
public class MyAppServiceImpl implements MyAppService {

	@Autowired
	private MockService mockService;
	
	@Override
	public List<Product> getSimilarProducts(String productId) {
		List<String> similarIds = mockService.getSimilarIds(productId);
		return similarIds.stream().map(id -> mapProduct(mockService.getMockProduct(id))).collect(Collectors.toList());
	}
	
	private Product mapProduct(MockProduct mockProduct) {
		Product product = new Product();
		product.setId(mockProduct.getId());
		product.setName(mockProduct.getName());
		product.setPrice(mockProduct.getPrice());
		product.setAvailability(mockProduct.getAvailability());
		
		return product;
	}
}
