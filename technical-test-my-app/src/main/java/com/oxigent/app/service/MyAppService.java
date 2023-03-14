package com.oxigent.app.service;

import java.util.List;

import com.oxigent.app.exception.MyAppException;
import com.oxigent.app.model.Product;

public interface MyAppService {

	public List<Product> getSimilarProducts(String productId);
	
}
