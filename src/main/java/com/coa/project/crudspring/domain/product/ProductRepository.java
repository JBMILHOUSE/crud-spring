package com.coa.project.crudspring.domain.product;

import org.springframework.data.mongodb.repository.MongoRepository;

// Esta interface é uma extensão do MongoRepository, que fornece métodos para realizar operações CRUD em uma coleção MongoDB.
// O primeiro parâmetro é o tipo da entidade (Product) com a qual esta interface trabalha.
// O segundo parâmetro é o tipo do identificador (ID) da entidade (String no caso de Product).
public interface ProductRepository extends MongoRepository<Product, String>{}