package com.tignestor.articulos.services;

import com.tignestor.articulos.dao.repositories.CustomerRepository;
import com.tignestor.articulos.errors.NotFoundException;
import com.tignestor.articulos.model.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImp implements ClienteService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> obtenerClientes() {
        return customerRepository.findAll();
    }

    @Override
    public Customer obtenerPorId(Long id) throws NotFoundException {
        Optional<Customer> cliente= customerRepository.findById(id);
        if(cliente.isEmpty()){  // verifica si es un valor vacio o null
            throw new NotFoundException("Customer no encontrado"); //Envio de mensaje al dto
        }else {
            return cliente.get();
        }
    }

    @Override
    public Customer crearCliente(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer actualizarCliente(Customer customer) {
        Customer customerEncontrado = customerRepository.findById(customer.getClienteId()).orElse(null);
        if (customerEncontrado !=null){
            customerEncontrado.setNombre(customer.getNombre());
            customerEncontrado.setApellido(customer.getApellido());
            return customerRepository.save(customerEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarCliente(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer encontrarPorNombre(String nombre) throws NotFoundException {
        Optional<Customer> cliente= customerRepository.findByNombre(nombre);
        if(cliente.isEmpty()){
            throw new NotFoundException("No existe un customer con ese nombre");
        }
        return cliente.get();

    }
}
