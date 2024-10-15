package org.example.service;

import org.example.domain.Platillo;
import org.example.interfas.PlatilloService;
import org.example.repository.DishRepository;

import java.util.List;

public class PlatilloServiceImpl implements PlatilloService {
    private final DishRepository platilloRepository;

    public PlatilloServiceImpl(DishRepository platilloRepository) {
        this.platilloRepository = platilloRepository;
    }

    @Override
    public void addPlatillo(Platillo platillo) {
        platilloRepository.save(platillo);
    }

    @Override
    public Platillo getPlatillo(int id) {
        return platilloRepository.findById(id);
    }

    @Override
    public List<Platillo> getAllPlatillos() {
        return platilloRepository.findAll();
    }

    @Override
    public void updatePlatillo(Platillo platillo) {
        platilloRepository.update(platillo);
    }

    @Override
    public void deletePlatillo(int id) {
        platilloRepository.delete(id);
    }
}