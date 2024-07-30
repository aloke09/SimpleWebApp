package com.bridgelabz.SpringWebApp.service;

import com.bridgelabz.SpringWebApp.model.Product;
import com.bridgelabz.SpringWebApp.repository.CRUD_Operation_using_JDBC;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Service//@component can also be used
public class ProductService
{

    static List<Product> products=new ArrayList<>(Arrays.asList(
            new Product(100,"iphone",100000)
            ,new Product(101,"S24 ultra",80000)));

    public List<Product> getProduct()
    {

        return products;

    }

    public  Product ByProductID(int pID)
    {
//        return products.stream().filter(f->f.getProductId()==pID).findFirst().get();

        return products.stream().filter(f->f.getProductId()==pID).findFirst()
                .orElse(new Product(404,"no item",0));
    }
    public void addProduct(Product product)
    {
        CRUD_Operation_using_JDBC.InsertProduct(product);
        products.add(product);
    }

    public void updateProduct(Product prod)
    {
        int index=0;
        for(int i=0;i<products.size();i++)
        {
            if(prod.getProductId()==products.get(i).getProductId())
            {
                index=i;
            }
        }
        products.set(index,prod);
    }

    public void deleteByID(int prodID)
    {
        int index=0;
        for(int i=0;i<products.size();i++)
        {
            if(prodID==products.get(i).getProductId())
            {
                index=i;
            }
        }
        products.remove(index);
    }
}
