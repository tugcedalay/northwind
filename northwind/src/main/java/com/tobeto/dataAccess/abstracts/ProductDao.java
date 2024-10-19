package com.tobeto.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tobeto.core.utilities.results.DataResult;
import com.tobeto.core.utilities.results.Result;
import com.tobeto.entities.concretes.Product;

//crud operasyonları yapmamızı sağlar 
//generic yapıda jpa repository her nesne için çalışır
//product icin calısıcam pk alanımın veri türü integer
public interface ProductDao extends JpaRepository<Product, Integer>{

}
