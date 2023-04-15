package com.example.bootquiz.Entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.ArrayList;
import java.util.List;

@Entity // 需要map到database
@Table(schema = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();
}

//    CREATE TABLE product (
//        id INT NOT NULL AUTO_INCREMENT,
//        name VARCHAR(255) NOT NULL,
//    PRIMARY KEY (id)
//);
//
//        CREATE TABLE item (
//        id INT NOT NULL AUTO_INCREMENT,
//        product_id INT NOT NULL,
//        PRIMARY KEY (id),
//        FOREIGN KEY (product_id) REFERENCES product(id)
//        );