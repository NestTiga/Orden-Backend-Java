package com.tignestor.articulos.services;

import com.tignestor.articulos.models.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> obtenerClientes();
    Cliente obtenerPorId(Long id);
    Cliente crearCliente(Cliente cliente);
    Cliente actualizarCliente(Cliente cliente);
    void eliminarCliente(Long id);
}
