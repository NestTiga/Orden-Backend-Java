package com.tignestor.articulos.services;

import com.tignestor.articulos.model.entities.Orden;


import java.util.List;

public interface OrdenService {


    List<Orden> listarOrdenes();

    Orden guardarOrden(Orden orden);
}
