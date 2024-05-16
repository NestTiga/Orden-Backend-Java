package com.tignestor.articulos.services;

import com.tignestor.articulos.errors.NotFoundException;
import com.tignestor.articulos.model.entities.Customer;
import com.tignestor.articulos.dao.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    ClienteService clienteService; // inyección del servicio de customer
    @MockBean
    CustomerRepository customerRepository; // para simular el repositorio de customer

    @BeforeEach
    void setUp() {
        Customer customer =
                Customer.builder()
                        .clienteId(3L)
                        .nombre("Néstor")
                        .apellido("Tigasi")
                        .build();
        Mockito.when(customerRepository.findByNombre("Néstor")).thenReturn(Optional.of(customer));
        /*simula la funcionalidad del repository, si recibe el nombre especificado
         retorna un objeto customer que fue construido con build para simular un usuario
         guardado en una base de datos.

        */
    }

    @Test
    @DisplayName("Prueba sobre el método de encotrar un customer por su nombre")
    public void encontrarClientePorNombrePrueba() throws NotFoundException {
        String nombreClienteDeseado="Néstor";
        Customer customerEncontrado = clienteService.encontrarPorNombre(nombreClienteDeseado);
        assertEquals(nombreClienteDeseado, customerEncontrado.getNombre());
        System.out.println("Customer encontrado: " + customerEncontrado);

        /*
        simulo el metodo encontrarPorNombre del servicio para encontrar un customer por su nombre,
        este método a la vez llama al método de CustomerRepository para cumplir con su objetivo.
        También se hace presente las excepciones experadas en caso de tenerlas.
         */
    }


}