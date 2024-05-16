package com.tignestor.articulos.services;

import com.tignestor.articulos.errors.NotFoundException;
import com.tignestor.articulos.model.entities.Cliente;
import com.tignestor.articulos.dao.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImp implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerPorId(Long id) throws NotFoundException {
        Optional<Cliente> cliente=clienteRepository.findById(id);
        if(cliente.isEmpty()){  // verifica si es un valor vacio o null
            throw new NotFoundException("Cliente no encontrado"); //Envio de mensaje al dto
        }else {
            return cliente.get();
        }
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        Cliente clienteEncontrado= clienteRepository.findById(cliente.getClienteId()).orElse(null);
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

    @Override
    public Cliente encontrarPorNombre(String nombre) throws NotFoundException {
        Optional<Cliente> cliente=clienteRepository.findByNombre(nombre);
        if(cliente.isEmpty()){
            throw new NotFoundException("No existe un cliente con ese nombre");
        }
        return cliente.get();

    }
}
