package com.tignestor.articulos.services;

import com.tignestor.articulos.models.Articulo;

import java.util.List;

public interface ArticuloService {
    List<Articulo> obtenerArticulos();
    Articulo crearArticulo(Articulo articulo);
}
