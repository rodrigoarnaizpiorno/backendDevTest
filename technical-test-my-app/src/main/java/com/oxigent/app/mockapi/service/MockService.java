package com.oxigent.app.mockapi.service;

import java.util.List;

import com.oxigent.app.exception.MyAppException;
import com.oxigent.app.mockapi.model.MockProduct;

public interface MockService {

	public List<String> getSimilarIds(String productId);
	public MockProduct getMockProduct(String productId);
	
}
