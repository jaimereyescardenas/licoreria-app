package cl.challenge.licoreria.utils;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cl.challenge.licoreria.entity.Product;

@Service
public class ProductUtils {

	public static List<Product> formatProducts(Collection<Product> products) {
		
		Set<Product> formattedProducts = products.stream()
			.map(product -> {
				if (product.getUrlImage() == null || product.getUrlImage().equals("")) {
					product.setUrlImage("img/no-disponible.png");
				}
				return product;
			})
			.collect(Collectors.toSet());
		
		List<Product> orderedProducts = formattedProducts.stream()
			.sorted((product1, product2) -> product1.getId() - product2.getId())
			.collect(Collectors.toList());
		
		return orderedProducts;
	}
	
}
