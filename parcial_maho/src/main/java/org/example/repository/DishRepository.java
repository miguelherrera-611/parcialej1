package org.example.repository;


import  org.example.domain.Platillo;
import java.util.List;

public interface DishRepository {
    void save(Platillo platillo);
    Platillo findById(int id);
    List<Platillo> findAll();
    void update(Platillo platillo);
    void delete(int id);
}
