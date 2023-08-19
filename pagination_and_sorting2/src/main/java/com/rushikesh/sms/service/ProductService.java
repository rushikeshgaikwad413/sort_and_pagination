package com.rushikesh.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rushikesh.sms.entity.Product;
import com.rushikesh.sms.repository.ProductRepository;




@Service
public class ProductService {

	 @Autowired
	    private ProductRepository repository;

	 
	   public Product createProduct(Product product) {
		    Product newProduct = new Product(product.getName(), product.getQuantity(), product.getPrice());
		    return repository.save(newProduct);
		 }
	   
	   public List<Product> findProductsByName(String name) {
		    return repository.findByNameContainingIgnoreCase(name);
		}

	   
	   
	    public List<Product> findAllProducts(){
	    	return repository.findAll();
	    }
	    
	    // for asc
	    
	    public List<Product> findProductsWithSorting(String field){
	        return  repository.findAll(Sort.by(Sort.Direction.ASC,field));
	    }
	    
	    // for desc
	    
	    public List<Product> findProductsWithdesc(String field){
	        return  repository.findAll(Sort.by(Sort.Direction.DESC,field));
	    }
	    
	    
	    
	    //find product with pagination..
	    public Page<Product> findProductWithPagination(int offset, int pageSize){
			Page<Product> products = repository.findAll(PageRequest.of(offset, pageSize));
			return products;
	    	
	    }
	    
	    public Page<Product> findProductWithPaginationandSorting(int offset, int pageSize, String field){
			Page<Product> products = repository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
			return products;
	    	
	    }



}
