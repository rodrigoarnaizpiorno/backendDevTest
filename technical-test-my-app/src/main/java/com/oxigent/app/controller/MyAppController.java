package com.oxigent.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.oxigent.app.exception.MyAppException;
import com.oxigent.app.model.Product;
import com.oxigent.app.service.MyAppService;

@RestController
public class MyAppController {

	@Autowired
	private MyAppService service;
	
	@GetMapping("/product/{productId}/similar")
	public ResponseEntity<?> getSimilarProducts(@PathVariable String productId){
		try {
			List<Product> products = service.getSimilarProducts(productId);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (MyAppException ex) {
            return new ResponseEntity<>(ex.getMessage(), ex.getStatus());
        }
	}
}
