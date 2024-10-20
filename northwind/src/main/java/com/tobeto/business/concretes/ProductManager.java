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


	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductName(productName), "Data listelendi");
	}


	@Override
	public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
		//business codes here
		
		return new SuccessDataResult<Product>
		(this.productDao.getByProductNameAndCategory(productName,categoryId), "Data listelendi");
		//arayüzün bana gönderdiği parametreleri daoya gönderdim idyi koydum
	}


	@Override
	public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory(productName, categoryId), "Data listelendi");
	}


	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategoryIn(categories), "Data listelendi");
	}


	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName), "Data listelendi");
	}


	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName), "Data listelendi");
	}


	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByNameAndCategory(productName, categoryId), "Data listelendi");
	}

}
