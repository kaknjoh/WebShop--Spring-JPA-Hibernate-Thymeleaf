package com.webshop.WebShop.repository;

import com.webshop.WebShop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository  extends JpaRepository<Product, Long> {
    @Query(value="SELECT *FROM products p where p.category_id=:categoryId",
    nativeQuery = true)
public List<Product> findByCategory(@Param("categoryId") long categoryId);

}
