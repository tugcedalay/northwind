package com.tobeto.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tobeto.core.utilities.results.DataResult;
import com.tobeto.core.utilities.results.Result;
import com.tobeto.entities.concretes.Product;
import com.tobeto.entities.dtos.ProductWithCategoryDto;

@Service
public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAllSorted();
    DataResult<List<Product>> getAll(int pageNo, int pageSize);
    
    
    
	Result add(Product product);
	
	 DataResult<Product> getByProductName(String productName);
     
	 DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
     
     
	 DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
     
  
	 DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
     
	 DataResult<List<Product>> getByProductNameContains(String productName);
     
	 DataResult<List<Product>> getByProductNameStartsWith(String productName);
     
    
	 DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
	 
	 DataResult<List<ProductWithCategoryDto>>  getProductWithCategoryDetails();
	 
}
