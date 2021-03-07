package cl.challenge.licoreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.challenge.licoreria.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
