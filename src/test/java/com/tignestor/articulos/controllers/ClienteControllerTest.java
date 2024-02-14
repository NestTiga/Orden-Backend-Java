package com.tignestor.articulos.controllers;

import com.tignestor.articulos.models.Cliente;
import com.tignestor.articulos.services.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ClienteService clienteService;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente =
                Cliente.builder()
                        .clienteId(5l)
                        .nombre("Néstor")
                        .apellido("Tigasi")
                        .build();
    }

    @Test
    public void crearClienteTest() throws Exception {
        String nombre="Néstor";

        Mockito.when(clienteService.encontrarPorNombre(nombre)).thenReturn(cliente);
        mockMvc.perform(get("/api/clientePorNombre/Néstor").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value(cliente.getNombre()));
    }
}