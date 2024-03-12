package com.tignestor.articulos.repository;

import com.tignestor.articulos.models.Orden;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrdenRepositoryTest {
    
    @Autowired
    private OrdenRepository ordenRepository;
    
    @Test
    public void listarOrdenes(){
        List<Orden> ordenLis= ordenRepository.findAll();
        System.out.println("ordenLis = " + ordenLis);
    }

}