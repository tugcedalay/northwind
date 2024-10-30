package com.tobeto.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tobeto.core.utilities.results.DataResult;
import com.tobeto.core.utilities.results.Result;
import com.tobeto.entities.concretes.Product;
import com.tobeto.entities.dtos.ProductWithCategoryDto;

//crud operasyonları yapmamızı sağlar 
//generic yapıda jpa repository her nesne için çalışır
//product icin calısıcam pk alanımın veri türü integer
//getBy ilgili kolona gider ve ver kosulu yazar
public interface ProductDao extends JpaRepository<Product, Integer>{
      Product getByProductName(String productName);
      
      Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
      
      
      //iki kolonu da getirebilecegi icin or kullanırken list kullandim
      
      List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
      
      //select* from products where product_name = abc or category_id = 1
      //select* from products where category_id in(1, 2, 3, 4) 
      
      List<Product> getByCategoryIn(List<Integer> categories);
      
      List<Product> getByProductNameContains(String productName);
      
      List<Product> getByProductNameStartsWith(String productName);
      
      //queryde entityden yazdık, parametre iki noktalı
      @Query("From Product where productName =:productName and category.categoryId=:categoryId")
      List<Product> getByNameAndCategory(String productName, int categoryId);
      
      //select * from products where product_name = abc and categoryId=abc
      
      //----------------------------------------------------------------------------
      
      @Query("Select new com.tobeto.entities.dtos.ProductWithCategoryDto"
      		+ "(p.id, p.productName, c.categoryName) " +
    	       "FROM Category c INNER JOIN c.products p")
      List<ProductWithCategoryDto> getProductWithCategoryDetails();
      
      //select p.prpoductId, p.productName, c.categoryName from Category c inner join Product p 
      //on c.categoryId = p.categoryId--jpquelde yazmaya gerek yok
}
