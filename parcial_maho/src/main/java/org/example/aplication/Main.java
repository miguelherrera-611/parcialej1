package org.example.aplication;

import org.example.domain.Platillo;
import org.example.interfas.PlatilloService;
import org.example.repository.PlatilloRepositoryImpl;
import org.example.service.PlatilloServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlatilloRepositoryImpl platilloRepository = new PlatilloRepositoryImpl();
        PlatilloService platilloService = new PlatilloServiceImpl(platilloRepository);

        platilloService.addPlatillo(new Platillo(1, "Tacos", "Tacos de carne asada"));
        platilloService.addPlatillo(new Platillo(2, "Ensalada", "Ensalada César con pollo"));

        List<Platillo> platillos = platilloService.getAllPlatillos();
        platillos.forEach(platillo -> System.out.println(platillo.getNombre() + " - " + platillo.getDescripcion()));

        Platillo platilloToUpdate = new Platillo(1, "Tacos", "Tacos de pollo");
        platilloService.updatePlatillo(platilloToUpdate);

        System.out.println("Después de la actualización:");
        platillos = platilloService.getAllPlatillos();
        platillos.forEach(platillo -> System.out.println(platillo.getNombre() + " - " + platillo.getDescripcion()));

        platilloService.deletePlatillo(2);

        System.out.println("Después de la eliminación:");
        platillos = platilloService.getAllPlatillos();
        platillos.forEach(platillo -> System.out.println(platillo.getNombre() + " - " + platillo.getDescripcion()));
    }
}

