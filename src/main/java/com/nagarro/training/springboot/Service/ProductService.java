package com.nagarro.training.springboot.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.training.springboot.Model.AllProduct;
import com.nagarro.training.springboot.Repository.AllproductRepository;
import com.nagarro.training.springboot.ServiceInterface.ProductServiceInterface;

@Service
public class ProductService implements ProductServiceInterface {
	private AllproductRepository allproductRepository;

	public ProductService(AllproductRepository allproductRepository) {
		super();
		this.allproductRepository = allproductRepository;
	}

// get product by id for view details
	@Override
	public AllProduct getProductByID(Long id) {
		AllProduct al = new AllProduct();
		AllProduct allproduct = (AllProduct) this.allproductRepository.getReferenceById(id);
		al.setBrand((String) allproduct.getBrand());
		al.setImage((String) allproduct.getImage());
		al.setName((String) allproduct.getName());
		al.setPrice((long) allproduct.getPrice());
		al.setProductcode((String) allproduct.getProductcode());
		al.setDescription((String) allproduct.getDescription());
		al.setId(((allproduct.getId())));
		System.out.println(al + "this is hmm");
		return al;
	}

// get all product
	@Override
	public List<AllProduct> getAllProduct() {
		return this.allproductRepository.findAll();
	}

	@Override
	public AllProduct saveProduct(AllProduct allproduct) {
		return this.allproductRepository.save(allproduct);

	}

// delete product by id
	@Override
	public void deleteProduct(long id) {
		this.allproductRepository.deleteById(id);

	}

//update product by id
	@Override
	public AllProduct updateProduct(AllProduct product, long id) {
		AllProduct productexist = this.allproductRepository.getReferenceById(id);
		if (productexist != null) {
			productexist.setId(product.getId());
			productexist.setBrand(product.getBrand());
			productexist.setImage(product.getImage());
			productexist.setName(product.getName());
			productexist.setPrice(product.getPrice());
			productexist.setProductcode(product.getProductcode());
			this.allproductRepository.save(productexist);
		} else
			return null;
		return productexist;

	}

}
