package cl.challenge.licoreria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter @Setter
@NoArgsConstructor
public class Product {

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "url_image", length = 150)
	private String urlImage;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "discount")
	private Integer discount;
	
	@ManyToOne
	@JoinColumn(name = "category")
	private Category category;
	
}
