package com.coa.project.crudspring.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coa.project.crudspring.domain.product.Product;
import com.coa.project.crudspring.domain.product.ProductRepository;
import com.coa.project.crudspring.domain.product.RequestProduct;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    
    // Método GET para obter todos os produtos
    @GetMapping
    public ResponseEntity getAllProducts() {
        var allProducts = productRepository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    // Método POST para criar um novo produto
    @PostMapping
    public ResponseEntity createProduct(@RequestBody @Validated RequestProduct data) {
       Product newProduct = new Product(data);
        
       productRepository.save(newProduct);
       return ResponseEntity.ok().build();
    }

    // Método PUT para atualizar um produto existente
    @PutMapping
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Validated RequestProduct data) {
      Optional<Product> optionalProduct = productRepository.findById(data.id());

      if(optionalProduct.isPresent()) {
        Product product = optionalProduct.get();
        product.setName(data.name());
        product.setPrice((int) data.price());
        productRepository.save(product);
        return ResponseEntity.ok(product);
      } else {
        return ResponseEntity.notFound().build();
      }
    }

    // Método DELETE para excluir um produto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id) {
      productRepository.deleteById(id);
      return ResponseEntity.noContent().build();
    }
}
