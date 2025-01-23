package com.F5.ALSports.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="categories")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    //private long ProductId;


    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }
}
