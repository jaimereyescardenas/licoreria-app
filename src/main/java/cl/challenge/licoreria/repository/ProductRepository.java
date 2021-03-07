package cl.challenge.licoreria.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.challenge.licoreria.entity.Category;
import cl.challenge.licoreria.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public Set<Product> findByCategory(Category category);
	public Set<Product> findByNameContainingIgnoreCase(String name);
	public Set<Product> findByCategoryAndNameContainingIgnoreCase(Category category, String name);

}
