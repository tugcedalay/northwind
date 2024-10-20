package com.tobeto.business.abstracts;

import java.util.List;

import com.tobeto.core.utilities.results.DataResult;
import com.tobeto.core.utilities.results.Result;
import com.tobeto.entities.concretes.Product;

public interface ProductService {
    DataResult<List<Product>> getAll();
	Result add(Product product);
	
	 DataResult<Product> getByProductName(String productName);
     
	 DataResult<Product> getByProductNameAndCategory(String productName, int categoryId);
     
     
	 DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);
     
  
	 DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
     
	 DataResult<List<Product>> getByProductNameContains(String productName);
     
	 DataResult<List<Product>> getByProductNameStartsWith(String productName);
     
    
	 DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
}
