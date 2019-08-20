package com.codingdojo.ecommerce.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.ecommerce.models.Category;
import com.codingdojo.ecommerce.models.CategoryProduct;
import com.codingdojo.ecommerce.models.Product;
import com.codingdojo.ecommerce.repositories.CategoryProductRepository;
import com.codingdojo.ecommerce.repositories.CategoryRepository;
import com.codingdojo.ecommerce.repositories.ProductRepository;

@Service
public class InventoryService {
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private CategoryProductRepository catProdRepo;

	public Product createNewProduct(@Valid Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	public Product findOneProduct(Long id) {
		// TODO Auto-generated method stub
		Optional<Product> optProduct = productRepo.findById(id);
		if(optProduct.isPresent()) {
			return optProduct.get();
		} else {
			return null;
		}
		
	}

	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

	public Category createNewCategory(@Valid Category category) {
		// TODO Auto-generated method stub
		return categoryRepo.save(category);
	}

	public CategoryProduct createCatProd(@Valid CategoryProduct catProd) {
		// TODO Auto-generated method stub
		return catProdRepo.save(catProd);
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	public Category findOneCategory(Long id) {
		Optional<Category> optCategory = categoryRepo.findById(id);
		if(optCategory.isPresent()) {
			return optCategory.get();
		} else {
			return null;
		}
		
	}

	public CategoryProduct createProdToCat(@Valid CategoryProduct Prodcat) {
		// TODO Auto-generated method stub
		return catProdRepo.save(Prodcat);
	}

}
