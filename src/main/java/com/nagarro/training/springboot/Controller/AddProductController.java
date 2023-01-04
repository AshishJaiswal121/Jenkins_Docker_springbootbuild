package com.nagarro.training.springboot.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.springboot.Model.AllProduct;
import com.nagarro.training.springboot.ServiceInterface.ProductServiceInterface;

//Add Product API
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AddProductController {

	@Autowired
	private ProductServiceInterface productserviceinterface;

//get all product 
	@RequestMapping(value = "/allProduct", method = RequestMethod.GET)
	public ResponseEntity<List<AllProduct>> getAllProduct() {

		List<AllProduct> allproduct_list = productserviceinterface.getAllProduct();
		if (allproduct_list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(allproduct_list));
	}

//get product by id
	@GetMapping("/allProduct/{id}")
	public ResponseEntity<AllProduct> getProductById(@PathVariable("id") long id) {
		AllProduct allproduct = productserviceinterface.getProductByID(id);
		if (allproduct == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(allproduct));
	}

//add product using post method
	@PostMapping("/allProduct")
	public ResponseEntity<AllProduct> addProduct(@RequestBody AllProduct allproduct) {

		try {
			allproduct = this.productserviceinterface.saveProduct(allproduct);
			return ResponseEntity.of(Optional.of(allproduct));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

//delete product by id
	@DeleteMapping("/allProduct/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id) {

		try {
			this.productserviceinterface.deleteProduct(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

//update product by id
	@PutMapping("/allProduct/{id}")
	public ResponseEntity<AllProduct> updateProduct(@RequestBody AllProduct product, @PathVariable("id") int id) {

		try {
			this.productserviceinterface.updateProduct(product, id);
			return ResponseEntity.ok().body(product);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
