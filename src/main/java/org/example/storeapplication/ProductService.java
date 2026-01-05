package org.example.storeapplication;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void insertProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(()-> new IllegalStateException(id + "Product Not Found"));
    }
}
