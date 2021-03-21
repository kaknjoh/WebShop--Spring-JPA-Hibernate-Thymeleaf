package com.webshop.WebShop.service;

import com.webshop.WebShop.domain.Product;
import com.webshop.WebShop.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService{

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public void saveProduct(Product s, MultipartFile file)  throws IOException {

        String name= StringUtils.cleanPath(file.getOriginalFilename());
        s.setFileName(name);
        s.setFileType(file.getContentType());
        s.setData(Base64.getEncoder().encodeToString(file.getBytes()));

        productsRepository.save(s);

    }

    @Override
    public List<Product> getAll() {
        return productsRepository.findAll();
    }


    @Override
    public List<Product> getByCategory(long id) {
       return productsRepository.findByCategory(id);
    }

    @Override
    public Product getById(long id){
        return productsRepository.findById(id).orElse(null);
    }


    @Override
    public boolean saveChanges() {

        try{
            productsRepository.flush();
            return true;
        }catch(Exception e){
            return false;

        }

    }
}
