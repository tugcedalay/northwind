package com.tobeto.business.abstracts;

import java.util.List;

import com.tobeto.core.utilities.results.DataResult;
import com.tobeto.core.utilities.results.Result;
import com.tobeto.entities.concretes.Product;

public interface ProductService {
   DataResult<List<Product>> getAll();
	Result add(Product product);
}
