package com.tignestor.articulos.services;

import com.tignestor.articulos.errors.NotFoundException;
import com.tignestor.articulos.model.entities.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> obtenerClientes();
    Cliente obtenerPorId(Long id) throws NotFoundException;
    Cliente crearCliente(Cliente cliente);
    Cliente actualizarCliente(Cliente cliente);
    void eliminarCliente(Long id);

    Cliente encontrarPorNombre(String nombre) throws NotFoundException;
}
