package com.tobeto.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.business.abstracts.ProductService;
import com.tobeto.core.utilities.results.DataResult;
import com.tobeto.core.utilities.results.Result;
import com.tobeto.core.utilities.results.SuccessDataResult;
import com.tobeto.core.utilities.results.SuccessResult;
import com.tobeto.dataAccess.abstracts.ProductDao;
import com.tobeto.entities.concretes.Product;


@Service
public class ProductManager implements ProductService{
 
	private ProductDao productDao;
	
	//autowired springten gelir, spring arka planda buna karsılık gelicek productdaonun instınsı olucak sınıfı uretip veriyor.
	//cons injection yaptık
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}


	@Override
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(), "Data listelendi");
				
	}


	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("ürün eklendi");
	}

}
