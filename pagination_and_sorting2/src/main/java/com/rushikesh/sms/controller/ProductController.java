package com.rushikesh.sms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rushikesh.sms.dto.APIResponse;
import com.rushikesh.sms.entity.Product;
import com.rushikesh.sms.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	@PostMapping
	public ResponseEntity<APIResponse<Product>> createProduct(@RequestBody Product product) {
	    Product newProduct = service.createProduct(product);
	    return ResponseEntity.status(HttpStatus.CREATED)
	                         .body(new APIResponse<>(1, newProduct));
	}
	
	@GetMapping("/search/{name}")
	public APIResponse<List<Product>> searchProductsByName(@PathVariable String name) {
	    List<Product> products = service.findProductsByName(name);
	    return new APIResponse<>(products.size(), products);
	}

	
	
	  @GetMapping
	    private APIResponse<List<Product>> getProducts() {
	        List<Product> allProducts = service.findAllProducts();
	        return new APIResponse<>(allProducts.size(), allProducts);
	    }
	  
	  
	  @GetMapping("/{field}")
	    private APIResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
	        List<Product> allProducts = service.findProductsWithSorting(field);
	       
	        return new APIResponse<>(allProducts.size(), allProducts);
	    }
	  
	  @GetMapping("/{descfield}")
	    private APIResponse<List<Product>> getProductsWithdescsort(@PathVariable String field) {
	        List<Product> allProducts = service.findProductsWithdesc(field);
	       
	        return new APIResponse<>(allProducts.size(), allProducts);
	    }
	  
	  @GetMapping("/pagination/{offset}/{pageSize}")
	    private APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
	        Page<Product> productsWithPagination = service.findProductWithPagination(offset, pageSize);
	        
	        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
	    }
	  
	  @GetMapping("/paginationandsort/{offset}/{pageSize}/{field}")
	    private APIResponse<Page<Product>> getProductsWithPaginationwithsort(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
	        Page<Product> productsWithPagination = service.findProductWithPaginationandSorting(offset, pageSize, field);
	        
	        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
	    }
	  


}
