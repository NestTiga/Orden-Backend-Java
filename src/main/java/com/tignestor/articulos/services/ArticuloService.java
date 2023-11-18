package com.tignestor.articulos.services;

import com.tignestor.articulos.models.Articulo;

import java.util.List;
import java.util.Set;

public interface ArticuloService {
    List<Articulo> obtenerArticulos();
    Articulo crearArticulo(Articulo articulo);
}
