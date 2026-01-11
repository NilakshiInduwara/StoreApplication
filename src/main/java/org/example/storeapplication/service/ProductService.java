package org.example.storeapplication.service;

import org.example.storeapplication.dto.ProductDTO;
import org.example.storeapplication.entity.Category;
import org.example.storeapplication.entity.Product;
import org.example.storeapplication.repository.CategoryRepository;
import org.example.storeapplication.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void insertProduct(ProductDTO productDto) {
        Category category = categoryRepository
                .findById(productDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setCategory(category);

        productRepository.save(product);
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(()-> new IllegalStateException(id + "Product Not Found"));
    }
}
