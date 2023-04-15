package com.example.bootquiz.Controller;

import com.example.bootquiz.Dao.ProductDao;
import com.example.bootquiz.Entity.Item;
import com.example.bootquiz.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemViewController {
    @Autowired
    ProductDao dao;

    @GetMapping("product/{id}")
    public Product GetProduct(@PathVariable int id) {
        Optional<Product> product = dao.findById(id);

        if(product.isEmpty()) {
            return new Product();
        } else {
            return product.get();
        }
    }

    @GetMapping("products")
    public List<Product> ListProducts() {
        return dao.findAll();
    }

    @PostMapping("products")
    public Product AddProduct(@RequestBody Product product) {
        return dao.save(product);
    }

    @PostMapping("product/{id}/items")
    public Product AddProduct(@RequestBody Item item, @PathVariable int id) {
        Product product = dao.findById(id).get();
        item.setProduct(product);
        product.getItems().add(item);
        return dao.save(product);
    }
}