package com.tignestor.articulos.services;

import com.tignestor.articulos.models.Orden;
import com.tignestor.articulos.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenServiceImp implements OrdenService{
    @Autowired
    OrdenRepository ordenRepository;

    @Override
    public Orden crearOrden(Orden orden) {

        return ordenRepository.save(orden);
    }
}
