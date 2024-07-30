package com.bridgelabz.SpringWebApp.controller;

import com.bridgelabz.SpringWebApp.model.Product;
import com.bridgelabz.SpringWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController
{
    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProduct()
    {
        return service.getProduct();
    }//GET

    @GetMapping("/products/{pID}")
    public Product getByProductID(@PathVariable  int pID)//GET
    {
        return service.ByProductID(pID);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod)//post insert
    {
        System.out.println(prod);
        service.addProduct(prod);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod)
    {
        service.updateProduct(prod);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProductByID(@PathVariable int prodID)
    {
        service.deleteByID(prodID);
    }
}
