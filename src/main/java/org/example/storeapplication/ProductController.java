package org.example.storeapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @GetMapping
    public List<Product> getProducts() {
        return List.of(
                new Product(
                        1,
                        "Samsung",
                        "Phone",
                        234.34,
                        2,
                        11
                )
        );
    }
}
