package cl.challenge.licoreria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter @Setter
@NoArgsConstructor
@JsonIgnoreProperties(
  ignoreUnknown = true, 
  value = {
	"hibernateLazyInitializer",
	"handler",
	"category"})
public class Product {

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@Column(name = "url_image", length = 150, nullable = true)
	private String urlImage;
	
	@Column(name = "price", nullable = false)
	private Double price;
	
	@Column(name = "discount", nullable = false)
	private Integer discount;
	
	@ManyToOne
	@JoinColumn(name = "category")
	private Category category;
	
}
