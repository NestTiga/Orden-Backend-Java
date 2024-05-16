package com.tignestor.articulos.services;

import com.tignestor.articulos.model.entities.Articulo;
import com.tignestor.articulos.dao.repositories.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloServiceImp implements ArticuloService{
    @Autowired
    ArticuloRepository articuloRepository;

    @Override
    public List<Articulo> obtenerArticulos() {
        return articuloRepository.findAll();
    }

    @Override
    public Articulo crearArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }
}
