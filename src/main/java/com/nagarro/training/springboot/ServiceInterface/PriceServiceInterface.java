package com.nagarro.training.springboot.ServiceInterface;

import java.util.List;

import com.nagarro.training.springboot.Model.AllProduct;

//Interface for Getting price And filter.
public interface PriceServiceInterface {

	List<AllProduct> getPriceByAccendingOrder();

	List<AllProduct> getPriceByDescendingOrder();
}
