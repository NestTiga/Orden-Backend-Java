package com.tignestor.articulos.services;

import com.tignestor.articulos.model.entities.Orden;
import com.tignestor.articulos.dao.repositories.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdenServiceImp implements OrdenService{
    @Autowired
    OrdenRepository ordenRepository;


    @Override
    public List<Orden> listarOrdenes() {
        return ordenRepository.findAll();
    }

    @Transactional
    @Override
    public Orden guardarOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

}
