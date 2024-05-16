package com.tignestor.articulos.repository;

import com.tignestor.articulos.dao.repositories.CustomerRepository;
import com.tignestor.articulos.model.entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Customer customer =
                Customer.builder()
                        .nombre("Edison")
                        .apellido("Pingos")
                        .build();
        testEntityManager.persist(customer);
    }

    // Prueba unitaria en caso de encontrar al customer
    @Test
    public void findByNombreFound(){
        Optional<Customer> cliente= customerRepository.findByNombre("Edison");
        assertEquals(cliente.get().getNombre(),"Edison");
        System.out.println("El customer encontrado es: " + cliente.get());
    }
}