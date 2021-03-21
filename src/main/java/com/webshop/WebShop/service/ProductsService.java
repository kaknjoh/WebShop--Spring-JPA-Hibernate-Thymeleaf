package com.webshop.WebShop.service;


import com.webshop.WebShop.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public interface ProductsService {

    public void saveProduct(Product s, MultipartFile file) throws IOException ;
    public List<Product> getAll();
    public List<Product> getByCategory(long id);
    public Product getById(long id);
    public boolean saveChanges();

}
