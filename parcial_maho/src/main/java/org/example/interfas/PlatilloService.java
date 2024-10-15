package org.example.interfas;

import org.example.domain.Platillo;

import java.util.List;

public interface PlatilloService {
    void addPlatillo(Platillo platillo);
    Platillo getPlatillo(int id);
    List<Platillo> getAllPlatillos();
    void updatePlatillo(Platillo platillo);
    void deletePlatillo(int id);
}