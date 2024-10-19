package com.tobeto.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tobeto.core.utilities.results.DataResult;
import com.tobeto.core.utilities.results.Result;
import com.tobeto.entities.concretes.Product;

//crud operasyonları yapmamızı sağlar 
//generic yapıda jpa repository her nesne için çalışır
//product icin calısıcam pk alanımın veri türü integer
//getBy ilgili kolona gider ve ver kosulu yazar
public interface ProductDao extends JpaRepository<Product, Integer>{
      Product getByProdductName(String productName);
      
      Product getByProductNameAndCategoryId(String productName, int categoryId);
      
      
      //iki kolonu da getirebilecegi icin or kullanırken list kullandim
      
      List<Product> getByProductNameOrCategoryId(String productName, int categoryId);
      
      //select* from products where product_name = abc or category_id = 1
      //select* from products where category_id in(1, 2, 3, 4) 
      
      List<Product> getByCategoryIdIn(List<Integer> categories);
      
      List<Product> getByProductNameContains(String productName);
      
      List<Product> getByProductNameStartsWith(String productName);
      
      //queryde entityden yazdık, parametre iki noktalı
      @Query("From Product where productName =:productName and categoryId=:categoryId")
      List<Product> getByNameAndCategory(String productName, int categoryId);
      
      //select * from products where product_name = abc and categoryId=abc
}
