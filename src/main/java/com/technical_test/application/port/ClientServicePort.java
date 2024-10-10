package com.technical_test.application.port;

import com.technical_test.domain.client.Client;

import java.util.List;

public interface ClientServicePort {

    Client createClient(Client client);

    Client updateClient(Long id, Client clientUpdate);

    Client findClientById(Long id);

    void deleteClientById(Long id);

    List<Client> findAllClients();
}
