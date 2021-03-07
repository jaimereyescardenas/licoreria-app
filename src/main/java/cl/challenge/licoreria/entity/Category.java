package cl.challenge.licoreria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "category")
@Getter @Setter
@NoArgsConstructor
public class Category {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;

}
