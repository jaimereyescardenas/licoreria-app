package cl.challenge.licoreria.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.challenge.licoreria.entity.Category;
import cl.challenge.licoreria.entity.Product;
import cl.challenge.licoreria.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public Optional<Product> findById(Integer id) {
		return productRepo.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return productRepo.findAll();
	}

	@Override
	public Set<Product> findByCategory(Category category) {
		return productRepo.findByCategory(category);
	}

	@Override
	public Set<Product> findByName(String name) {
		return productRepo.findByNameContainingIgnoreCase(name);
	}

}
