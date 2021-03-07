package cl.challenge.licoreria.service;

import java.util.List;
import java.util.Optional;

import cl.challenge.licoreria.entity.Category;

public interface ICategoryService {

	public Optional<Category> findById(Integer id);
	public List<Category> findAll();
	
}
