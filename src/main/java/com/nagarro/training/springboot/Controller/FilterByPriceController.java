package com.nagarro.training.springboot.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.springboot.Model.AllProduct;
import com.nagarro.training.springboot.ServiceInterface.PriceServiceInterface;

//get price API
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FilterByPriceController {

	@Autowired
	private PriceServiceInterface priceserviceinterface;

//Get all product price ascending order.
	@RequestMapping(value = "/allProductByPriceaOrder", method = RequestMethod.GET)
	public ResponseEntity<List<AllProduct>> getPriceByAccendingOrder() {

		List<AllProduct> allproduct_list = priceserviceinterface.getPriceByAccendingOrder();
		if (allproduct_list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(allproduct_list));
	}

//Get all product price descending order.
	@RequestMapping(value = "/allProductByPricedOrder", method = RequestMethod.GET)
	public ResponseEntity<List<AllProduct>> getPriceByDescendingOrder() {

		List<AllProduct> allproduct_list = priceserviceinterface.getPriceByDescendingOrder();
		if (allproduct_list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(allproduct_list));
	}
}