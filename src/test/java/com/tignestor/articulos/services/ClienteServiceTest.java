package com.tignestor.articulos.services;

import com.tignestor.articulos.errors.NotFoundException;
import com.tignestor.articulos.model.entities.Cliente;
import com.tignestor.articulos.dao.repositories.ClienteRepository;
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
class ClienteServiceTest {

    @Autowired
    ClienteService clienteService; // inyección del servicio de cliente
    @MockBean
    ClienteRepository clienteRepository; // para simular el repositorio de cliente

    @BeforeEach
    void setUp() {
        Cliente cliente=
                Cliente.builder()
                        .clienteId(3L)
                        .nombre("Néstor")
                        .apellido("Tigasi")
                        .build();
        Mockito.when(clienteRepository.findByNombre("Néstor")).thenReturn(Optional.of(cliente));
        /*simula la funcionalidad del repository, si recibe el nombre especificado
         retorna un objeto cliente que fue construido con build para simular un usuario
         guardado en una base de datos.

        */
    }

    @Test
    @DisplayName("Prueba sobre el método de encotrar un cliente por su nombre")
    public void encontrarClientePorNombrePrueba() throws NotFoundException {
        String nombreClienteDeseado="Néstor";
        Cliente clienteEncontrado= clienteService.encontrarPorNombre(nombreClienteDeseado);
        assertEquals(nombreClienteDeseado, clienteEncontrado.getNombre());
        System.out.println("Cliente encontrado: " + clienteEncontrado);

        /*
        simulo el metodo encontrarPorNombre del servicio para encontrar un cliente por su nombre,
        este método a la vez llama al método de ClienteRepository para cumplir con su objetivo.
        También se hace presente las excepciones experadas en caso de tenerlas.
         */
    }


}