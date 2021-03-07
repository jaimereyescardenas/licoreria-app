package cl.challenge.licoreria.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter @Setter
@NoArgsConstructor
@JsonIgnoreProperties(
  ignoreUnknown = true, 
  value = {
	"hibernateLazyInitializer",
	"handler"})
public class Category {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "category")
	private Set<Product> products;

}
