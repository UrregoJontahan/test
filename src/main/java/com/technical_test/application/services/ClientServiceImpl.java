package com.technical_test.application.services;

import com.technical_test.application.port.ClientServicePort;
import com.technical_test.domain.client.Client;
import com.technical_test.infrastructure.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientServicePort {

    private final ClientRepository clientRepository;


    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long id, Client updatedClient) {
        Optional<Client> existingClient = clientRepository.findById(id);
        if (existingClient.isPresent()) {
            Client clientToUpdate = existingClient.get();
            clientToUpdate.setName(updatedClient.getName());
            clientToUpdate.setEmail(updatedClient.getEmail());
            clientToUpdate.setLastName(updatedClient.getLastName());
            return clientRepository.save(clientToUpdate);
        } else {
            throw new RuntimeException("Client with id " + id + "could not update ");
        }
    }

    @Override
    public Client findClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client " + id + " not found"));
    }

    @Override
    public void deleteClientById(Long id) {
        if (clientRepository.existsById(id)){
            clientRepository.deleteById(id);
        }else {
            throw new RuntimeException("Client with id " + id + " not exists");
        }
    }

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }
}
