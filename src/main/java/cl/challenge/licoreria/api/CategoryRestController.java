package cl.challenge.licoreria.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.challenge.licoreria.entity.Category;
import cl.challenge.licoreria.exception.ResourceNotFoundException;
import cl.challenge.licoreria.service.ICategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping("/list")
	public List<Category> getCategories() {
		return categoryService.findAll();
	}
	
	@GetMapping("/{id}")
	public Category getCategory(@PathVariable(name = "id", required = true) Integer categoryId) {
		
		Optional<Category> category = categoryService.findById(categoryId);
		
		if (category.isEmpty()) {
			throw new ResourceNotFoundException("Category id " + categoryId + " not found");
		}
		
		return category.get();
	}
	
	
}
