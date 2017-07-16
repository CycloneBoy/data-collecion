package com.cycloneboy.controller;

import com.cycloneboy.domain.Comment;
import com.cycloneboy.domain.Product;
import com.cycloneboy.repository.ProductRepository;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Created by CycloneBoy on 2017/7/16.
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

   // private ProductRepository productRepository = new ProductRepository();

    private Map<Integer,Product> productsById = new LinkedHashMap<Integer,Product>();


    public List<Product> findAll(){
        return  new ArrayList<Product>(this.productsById.values());
    }

    public Product findById(Integer id){
        return this.productsById.get(id);
    }

    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public ModelAndView getProductList(ModelMap model){

        Product prod1 = new Product(1, "Fresh Sweet Basil", true, 4.99);
        Product prod2 = new Product(2, "Italian Tomato", false, 1.25);
        Product prod3 = new Product(3, "Yellow Bell Pepper", true, 2.50);

        List<Comment> commentList = new ArrayList<Comment>();
        commentList.add(new Comment(1, "I'm so sad this product is no longer available!"));
        commentList.add(new Comment(2, "When do you expect to have it back?"));
        prod2.setComments(commentList);

        List<Product> productList = new ArrayList<Product>();
        productList.add(prod1);
        productList.add(prod2);
        productList.add(prod3);
        model.addAttribute("prods",productList);
        logger.info("产品列表: product/list: " + productList.size() + " " + productList.get(1).toString());
        return new ModelAndView("product/list");
    }

}
