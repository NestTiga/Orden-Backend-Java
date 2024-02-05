package com.tignestor.articulos.services;

import com.tignestor.articulos.models.Articulo;
import com.tignestor.articulos.models.Orden;
import com.tignestor.articulos.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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
