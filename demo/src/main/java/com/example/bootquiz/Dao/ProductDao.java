package com.example.bootquiz.Dao;

import com.example.bootquiz.Entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ProductDao extends JpaRepository<Product, Integer> {
}
