package com.tobeto.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@Entity
public class category {
	
  @Id
  @Column(name = "category_id")	
  private int categoryId;
  
  @Column(name = "category_name")
  private String categoryName;
  
  @OneToMany(mappedBy = "categories")
  private List<Product> products;
}
