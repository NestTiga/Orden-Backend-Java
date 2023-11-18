package com.tignestor.articulos.services;

import com.tignestor.articulos.models.Cliente;
import com.tignestor.articulos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        Cliente clienteEncontrado= clienteRepository.findById(cliente.getCliente_id()).orElse(null);
        if (clienteEncontrado!=null){
            clienteEncontrado.setNombre(cliente.getNombre());
            clienteEncontrado.setApellido(cliente.getApellido());
            return clienteRepository.save(clienteEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
