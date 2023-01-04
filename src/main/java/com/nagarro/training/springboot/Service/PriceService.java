package com.nagarro.training.springboot.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.training.springboot.Model.AllProduct;
import com.nagarro.training.springboot.Repository.AllproductRepository;
import com.nagarro.training.springboot.ServiceInterface.PriceServiceInterface;

@Service
public class PriceService implements PriceServiceInterface {

	private AllproductRepository allproductRepository;

	public PriceService(AllproductRepository allproductRepository) {
		super();
		this.allproductRepository = allproductRepository;
	}

	// filter price in ascending order
	@Override
	public List<AllProduct> getPriceByAccendingOrder() {
		List<AllProduct> allproduct = this.allproductRepository.findAll();
		Collections.sort(allproduct, Comparator.comparing(AllProduct::getPrice));
		return allproduct;
	}

	@Override
	public List<AllProduct> getPriceByDescendingOrder() {
		List<AllProduct> allproduct = this.allproductRepository.findAll();
		Collections.sort(allproduct, Comparator.comparing(AllProduct::getPrice).reversed());
		return allproduct;
	}
}
