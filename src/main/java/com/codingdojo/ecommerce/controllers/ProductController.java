package com.codingdojo.ecommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.ecommerce.models.Category;
import com.codingdojo.ecommerce.models.CategoryProduct;
import com.codingdojo.ecommerce.models.Product;
import com.codingdojo.ecommerce.services.InventoryService;

@Controller
public class ProductController {
	@Autowired
	private InventoryService invServ;
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("newProductObj") Product product) {
		return "products/new.jsp";
	}
	
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("newProductObj") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "products/new.jsp";
		}
		Product prod = invServ.createNewProduct(product);
		return "redirect:/products/"+ prod.getId();
	}
	
	@GetMapping ("/products/{id}")
	public String showProduct(Model model, @PathVariable("id") Long id, @ModelAttribute("middleTableObj") CategoryProduct catProd) {
		Product prod = invServ.findOneProduct(id);
		List<Category> allCats = invServ.getAllCategories();
		model.addAttribute("allCats", allCats);
		model.addAttribute("product", prod);
		
		return "products/show.jsp";
	}
	
	@PostMapping("/addCategory")
	public String addCategory(@Valid @ModelAttribute("middleTableObj") CategoryProduct catProd, BindingResult result) {
		if(result.hasErrors()) {
			return "products/new.jsp";
		}
		
		CategoryProduct cp = invServ.createCatProd(catProd);
		return "redirect:/products/" +cp.getProduct().getId();
	}
	
}
