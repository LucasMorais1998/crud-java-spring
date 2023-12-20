package com.youtubekipper.crudjavaspring.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "products")
@Entity(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer price;

    private Boolean active;

    public Product(ProductRequestDTO data) {
        this.name = data.name();
        this.price = data.price();
        this.active = true;
    }
}
