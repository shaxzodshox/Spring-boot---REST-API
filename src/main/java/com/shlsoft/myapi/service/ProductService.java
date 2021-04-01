package com.shlsoft.myapi.service;

import com.shlsoft.myapi.entity.Product;
import com.shlsoft.myapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    //POST - save single object
    public Product saveProduct(Product product){
        return repository.save(product);
    }

    //POST - save list of objects
    public List<Product> saveProducts(List<Product> product){
        return repository.saveAll(product);
    }

    //GET - return list of objects
    public List<Product> getProducts(){
        return repository.findAll();
    }

    //GET - return single object by id
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    //GET - return single object by name
    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    //DELETE - delete object based on the id
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Item deleted:" + id;
    }

    //PUT - update the existing object
    public Product updateProduct(Product product){
        //Fetching the old product
        Product existing_product = repository.findById(product.getId()).orElse(null);
        //Updating the value
        existing_product.setName(product.getName());
        existing_product.setQuantity(product.getQuantity());
        existing_product.setPrice(product.getPrice());

        //Saving the new object instead of existing object
        return repository.save(existing_product);
    }

}
