package com.tignestor.articulos.services;

import com.tignestor.articulos.errors.NotFoundException;
import com.tignestor.articulos.model.entities.Customer;

import java.util.List;

public interface ClienteService {
    List<Customer> obtenerClientes();
    Customer obtenerPorId(Long id) throws NotFoundException;
    Customer crearCliente(Customer customer);
    Customer actualizarCliente(Customer customer);
    void eliminarCliente(Long id);

    Customer encontrarPorNombre(String nombre) throws NotFoundException;
}
