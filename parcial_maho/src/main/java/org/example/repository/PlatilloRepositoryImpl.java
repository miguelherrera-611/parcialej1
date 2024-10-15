package org.example.repository;

import org.example.domain.Platillo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlatilloRepositoryImpl implements DishRepository {
    private final String filePath = "platillos.dat";

    @Override
    public void save(Platillo platillo) {
        List<Platillo> platillos = findAll();
        platillos.add(platillo);
        serialize(platillos);
    }

    @Override
    public Platillo findById(int id) {
        List<Platillo> platillos = findAll();
        return platillos.stream().filter(platillo -> platillo.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Platillo> findAll() {
        List<Platillo> platillos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            platillos = (List<Platillo>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Archivo no encontrado, retornamos lista vacía
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return platillos;
    }

    @Override
    public void update(Platillo platillo) {
        List<Platillo> platillos = findAll();
        for (int i = 0; i < platillos.size(); i++) {
            if (platillos.get(i).getId() == platillo.getId()) {
                platillos.set(i, platillo);
                break;
            }
        }
        serialize(platillos);
    }

    @Override
    public void delete(int id) {
        List<Platillo> platillos = findAll();
        platillos.removeIf(platillo -> platillo.getId() == id);
        serialize(platillos);
    }

    private void serialize(List<Platillo> platillos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(platillos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
