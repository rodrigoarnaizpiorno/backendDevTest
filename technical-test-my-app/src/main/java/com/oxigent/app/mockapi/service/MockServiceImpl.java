package com.oxigent.app.mockapi.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.oxigent.app.exception.MyAppException;
import com.oxigent.app.mockapi.model.MockProduct;

@Component
public class MockServiceImpl implements MockService {

	@Autowired
	private RestTemplate restClient;
	
	@Override
	public List<String> getSimilarIds(String productId) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("productId", productId);
		try {
			List<String> similarIds = Arrays.asList(restClient.getForObject("http://localhost:3001/product/{productId}/similarids", 
																			String[].class, 
																			pathVariables));
			return similarIds;
		}catch (Exception ex) {
			throw new MyAppException("Product Not found", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public MockProduct getMockProduct(String productId) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("productId", productId);
		try {
			MockProduct mockProduct = restClient.getForObject("http://localhost:3001/product/{productId}", 
					  										  MockProduct.class,
					  										  pathVariables);
			return mockProduct;
		}catch (Exception ex) {
			throw new MyAppException("Product Not found", HttpStatus.NOT_FOUND);
		}
	}

	
	
}
