package com.nagarro.training.springboot.ServiceInterface;

import java.util.List;

import com.nagarro.training.springboot.Model.AllProduct;
//interface for Performing CRUD on Product Details
public interface ProductServiceInterface {
	List<AllProduct> getAllProduct();

	AllProduct saveProduct(AllProduct allproduct);

	AllProduct getProductByID(Long id);

	void deleteProduct(long id);

	AllProduct updateProduct(AllProduct product, long id);

}
