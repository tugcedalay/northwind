package com.tobeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.business.abstracts.ProductService;
import com.tobeto.core.utilities.results.DataResult;
import com.tobeto.core.utilities.results.Result;
import com.tobeto.entities.concretes.Product;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	
	private ProductService productService;
	//autowired arka planda newliyor referans tipleri
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
    	return this.productService.getAll();
    }
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product){
		return this.productService.add(product);
	}
	@GetMapping("/getByProductName")
	//yapılan isteği parametrelere bak productnamei oku atamasını yap pne gönder
	public DataResult<Product> getByProductName(@RequestParam  String productName) {
		return this.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> 
	getByProductNameAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
		
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}
	
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	
	@GetMapping("/getAllByPage")
	DataResult<List<Product>> getAll(int pageNo, int pageSize){
		 return this.productService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();	
		}
	
	
	@GetMapping("/getByProductNameStartsWith")
	DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName){
		return this.productService.getByProductNameStartsWith(productName);
	}
	
	
	@GetMapping("/getByNameAndCategory")
	DataResult<List<Product>> getByNameAndCategory(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
		return this.productService.getByNameAndCategory(productName, categoryId);
	}
	
}





//kodlama.io/api/products---domain adı kontroller buradan gelen isteği karsılar.