package com.example.gpc_p.controller;

import com.example.gpc_p.model.Product;
import com.example.gpc_p.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

////////////////////// Kontroler obsługujący żądania związane z produktami./////////////////////////////

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    ////////// Endpoint dla liczby rekordów //////////

    // @return ResponseEntity<Integer> z liczbą produktów jako ciało odpowiedzi
    @GetMapping("/count")
    public ResponseEntity<Integer> getProductCount() {
        int count = productService.getProductCount();
        return ResponseEntity.ok(count);
    }


    ////////// Endpoint dla listy wszystkich produktów //////////

    // @return ResponseEntity<List<Product>> z listą produktów jako ciało odpowiedzi
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }


    ////////// Endpoint zwracający produkt po podanej nazwie w formacie JSON //////////

    //@param name nazwa produktu
    //@return ResponseEntity<Product> z produktem jako ciało odpowiedzi
    @GetMapping("/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        Product product = productService.getProductByName(name);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }
}