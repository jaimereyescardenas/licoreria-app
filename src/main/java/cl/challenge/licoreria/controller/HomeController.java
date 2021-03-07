package cl.challenge.licoreria.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
		List<Product> products = productService.findAll();
		
		List<Product> formattedProducts = ProductUtils.formatProducts(products);
		
		mav.addObject("products", formattedProducts);
		return mav;
	}
	
}
