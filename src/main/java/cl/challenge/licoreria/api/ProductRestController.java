package cl.challenge.licoreria.api;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.challenge.licoreria.entity.Category;
import cl.challenge.licoreria.entity.Product;
import cl.challenge.licoreria.exception.ResourceNotFoundException;
import cl.challenge.licoreria.service.ICategoryService;
import cl.challenge.licoreria.service.IProductService;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping("/list")
	public List<Product> getProducts() {
		return productService.findAll();
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable(name = "id", required = true) Integer productId) {
		
		Optional<Product> product = productService.findById(productId);
		
		if (!product.isPresent()) {
			throw new ResourceNotFoundException("Product id " + productId + " not found");
		}
		
		return product.get();
	}
	
	@GetMapping("/search")
	public Set<Product> searchProductsByName(@RequestParam(name = "name", required = true) String name) {
		
		return productService.findByName(name);
	}
	
	@GetMapping("/category")
	public Set<Product> searchByCategory(@RequestParam(name = "id", required = true) Integer categoryId) {
		
		Optional<Category> category = categoryService.findById(categoryId);
		
		if (!category.isPresent()) {
			throw new ResourceNotFoundException("Category id " + categoryId + " not found");
		}
		
		return productService.findByCategory(category.get());
	}
	
}
