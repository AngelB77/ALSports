package com.F5.ALSports.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
    private String imageUrl;

    @ManyToOne
    @JsonIgnoreProperties("products")
    @JoinColumn(name="category_id")
    private Category category;

    public Product(@NotBlank(message = "Name is required") String name, int price, @NotBlank(message = "Url is required") String s) {
    }
}
