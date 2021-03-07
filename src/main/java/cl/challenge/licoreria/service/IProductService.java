package cl.challenge.licoreria.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cl.challenge.licoreria.entity.Category;
import cl.challenge.licoreria.entity.Product;

public interface IProductService {
	
	public Optional<Product> findById(Integer id);
	public List<Product> findAll();
	public Set<Product> findByCategory(Category category);
	public Set<Product> findByName(String name);
	public Set<Product> findByCategoryAndName(Category category, String name);

}
