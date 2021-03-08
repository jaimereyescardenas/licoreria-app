package cl.challenge.licoreria.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.challenge.licoreria.entity.Category;
import cl.challenge.licoreria.entity.Product;
import cl.challenge.licoreria.service.ICategoryService;
import cl.challenge.licoreria.service.IProductService;
import cl.challenge.licoreria.utils.ProductUtils;

@Controller
public class HomeController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping("/")
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("home");
		
		List<Category> categories = categoryService.findAll();
		
		List<Product> products = productService.findAll();
		List<Product> formattedProducts = ProductUtils.formatProducts(products);

		mav.addObject("categories", categories);
		mav.addObject("products", formattedProducts);
		return mav;
	}
	
	@GetMapping("/search")
	public ModelAndView searchProducts(@RequestParam(name = "category", required = true) Integer categoryId,
			@RequestParam(name = "name", required = true) String name) {
		ModelAndView mav = new ModelAndView("home");
		
		List<Category> categories = categoryService.findAll();
		Collection<Product> products = null;
		
		if (categoryId != 0) {
			Category category = categoryService.findById(categoryId).orElse(null);
			if (category == null) {
				products = productService.findByName(name);
			}
			products = productService.findByCategoryAndName(category, name);
		} else {			
			products = productService.findByName(name);
		}
		
		List<Product> formattedProducts = ProductUtils.formatProducts(products);

		mav.addObject("categories", categories);
		mav.addObject("products", formattedProducts);
		return mav;
	}
	
}
