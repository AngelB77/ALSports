package com.F5.ALSports.model;

import jakarta.persistence.*;

@Entity
@Table(name="categorys")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    //private long Productid;


    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }
}
