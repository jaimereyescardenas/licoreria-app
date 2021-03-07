package cl.challenge.licoreria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.challenge.licoreria.entity.Category;
import cl.challenge.licoreria.repository.CategoryRepository;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public Optional<Category> findById(Integer id) {
		return categoryRepo.findById(id);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}

}
