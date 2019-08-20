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
public class CategoryController {
	@Autowired
	private InventoryService invServ;
	
	@GetMapping("/category/new")
	public String newCategory(@ModelAttribute("newCategoryObj") Category category) {
		return "categories/new.jsp";
	}
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("newCategoryObj") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "categories/new.jsp";
		} 
		invServ.createNewCategory(category);
		
		return "redirect:/products/new";
	}
	@GetMapping ("/categories/{id}")
	public String showCategory(Model model, @PathVariable("id") Long id, @ModelAttribute("middleTableObj") CategoryProduct catProd) {
		Category cat = invServ.findOneCategory(id);
		List<Product> allProducts = invServ.getAllProducts();
		model.addAttribute("allProducts", allProducts);
		model.addAttribute("category", cat);
		
		return "categories/show.jsp";
	}
	@PostMapping("/addProduct")
	public String addProduct(@Valid @ModelAttribute("middleTableObj") CategoryProduct Prodcat, BindingResult result) {
		if(result.hasErrors()) {
			return "categories/show.jsp";
		}
		
		CategoryProduct cp = invServ.createProdToCat(Prodcat);
		return "redirect:/categories/" +cp.getCategory().getId();
	}
	
}
