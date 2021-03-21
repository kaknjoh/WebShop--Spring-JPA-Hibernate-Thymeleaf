package com.webshop.WebShop.repository;

import com.webshop.WebShop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
