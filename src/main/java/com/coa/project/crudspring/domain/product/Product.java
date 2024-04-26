package com.coa.project.crudspring.domain.product;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Esta anotação indica que a classe será mapeada para um documento MongoDB com o nome "product".
@Document("product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    // Gerando automaticamente um UUID para o id
    @Id 
    private String id = UUID.randomUUID().toString();

    // Esta anotação indica que o campo 'name' não pode ser nulo.
    // Se um valor nulo for atribuído a este campo, uma exceção será lançada.
    @Nonnull()
    private String name;

    // Esta anotação indica que o campo 'price' não pode ser nulo.
    // Se um valor nulo for atribuído a este campo, uma exceção será lançada.
    @Nonnull()
    private Integer price;

    public Product(RequestProduct requestProduct) {
        this.name = requestProduct.name();
        this.price = (int) requestProduct.price();
    }
}
