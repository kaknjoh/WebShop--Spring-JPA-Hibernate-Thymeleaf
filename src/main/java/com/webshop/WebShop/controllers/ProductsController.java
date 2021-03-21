package com.webshop.WebShop.controllers;

import com.webshop.WebShop.domain.Category;
import com.webshop.WebShop.domain.HelperProduct;
import com.webshop.WebShop.domain.Product;
import com.webshop.WebShop.repository.CategoryRepository;
import com.webshop.WebShop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductsController {
    @Autowired
    private ProductsService productsService;
    @Autowired
    private CategoryRepository categoryRepository;



    @GetMapping("/products")
    public String showProducts(Model model){

        List<Product> products=productsService.getAll();
        /*
        List<HelperProduct> helperProducts=new ArrayList<>();
        HelperProduct product=new HelperProduct();
        Product p;
        for(int i=0; i< products.size();i++){
            p=products.get(i);
            if(p.getData()!=null){

                product.setNaziv(p.getNaziv());
                product.setCijena(p.getCijena());
                product.setTezina(p.getTezina());
                product.setFileName(p.getFileName());
                product.setFileType(p.getFileType());
                //product.setData(Base64.getEncoder().encodeToString(p.getData()));
                product.setCategory(p.getCategory());
                product.setRok(p.getRok());

            }

            helperProducts.add(product);
        }
        */



        model.addAttribute("products", products);


        return "showproducts";

    }


    @GetMapping("/addproduct")
    public String showAddProductForm(Model model){
        model.addAttribute("product", new Product());
        List<Category> categoryList=categoryRepository.findAll();
        model.addAttribute("categories",categoryList) ;
        return "addproduct";
    }


    @PostMapping("/saveproduct")
    public String saveProduct(@ModelAttribute("products") Product product, @RequestParam("file") MultipartFile fil)  {
        String message="";
        try{
            productsService.saveProduct(product,fil );
            message="Succes";
            return "redirect:/";
        }catch(Exception e){
            message="Fail";
            return "redirect:/addproduct";

        }

    }

    @GetMapping("/product/details/{id}")
    public String productDetail(@PathVariable("id") long productid,Model model ){
        Product product=productsService.getById(productid);

        model.addAttribute("products",product);


        return "productdetail";
    }

    @GetMapping("/products/{categoryId}")
    public String productByCategories(@PathVariable("categoryId") long categoryId, Model model){
        List<Product> productByCategories=productsService.getByCategory(categoryId);
        String message="";



        if(productByCategories != null){
            //message="Asortiman"+ productByCategories.get(1).getCategory().getCategoryName();
            model.addAttribute("products",productByCategories);
            model.addAttribute("message", message);
            return "showproducts";
        }else {
            message="Nema proizvoda na stanju";

            return "/:";
        }

    }


    @GetMapping("/edit/{productid}")
    public String editPage(@PathVariable("productid") long id, Model model){
        Product product=productsService.getById(id);

        model.addAttribute("product", product);
        List<Category> categoryList=categoryRepository.findAll();
        model.addAttribute("categories",categoryList) ;
        return "updateproduct";

    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") long id, @ModelAttribute("products") Product product,
                                @RequestParam("file") MultipartFile file) throws IOException {

        productsService.saveProduct(product,file);
            /*
          Product productinDb=productsService.getById(id).orElse(null);
          if(productinDb==null){
              return "/404";
          }

          productinDb.setNaziv(product.getNaziv());
          productinDb.setCijena(product.getCijena());
          productsService.saveChanges();

             */
          return "redirect:/";




    }




}
