package com.shlsoft.myapi.repository;

import com.shlsoft.myapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Integer> {
        Product findByName(String name);
}
