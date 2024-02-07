package com.tignestor.articulos.repository;

import com.tignestor.articulos.models.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClienteRepositoryTest {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Cliente cliente=
                Cliente.builder()
                        .nombre("Edison")
                        .apellido("Pingos")
                        .build();
        testEntityManager.persist(cliente);
    }

    // Prueba unitaria en caso de encontrar al cliente
    @Test
    public void findByNombreFound(){
        Optional<Cliente> cliente= clienteRepository.findByNombre("Edison");
        assertEquals(cliente.get().getNombre(),"Edison");
        System.out.println("El cliente encontrado es: " + cliente.get());
    }
}