package com.company.clientes.clientesapp.service;

import com.company.clientes.clientesapp.model.Cliente;
import com.company.clientes.clientesapp.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements  IClienteService{
    @Autowired
    private IClienteRepository clienteRepository;


    @Override
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarClienteById(Long id) {
        return Optional.ofNullable(clienteRepository.findById(id).orElse(null));
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
         clienteRepository.delete(cliente);
    }


}
