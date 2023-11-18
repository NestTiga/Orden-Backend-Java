package com.tignestor.articulos.services;

import com.tignestor.articulos.models.Articulo;
import com.tignestor.articulos.models.Orden;
import com.tignestor.articulos.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrdenServiceImp implements OrdenService{
    @Autowired
    OrdenRepository ordenRepository;

    @Override
    public void crearOrden(Orden orden) {
        /*Set<Articulo> articulos = orden.getArticulos();
        for (Articulo articulo: articulos) {
            System.out.println("ID Articulo: " + articulo.getArticId());
            System.out.println("Nombre: " + articulo.getNombre());
        }*/
        System.out.println("Objeto completo enviado desde el front: " + orden);
        ordenRepository.save(orden);
        var respuesta=ordenRepository.save(orden);
        System.out.println("Respuesta de la base" + respuesta);

    }
}
