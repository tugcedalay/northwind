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
	
	
	
	
	
}





//kodlama.io/api/products---domain adı kontroller buradan gelen isteği karsılar.