package br.com.souzaos.souzaOs.services;


import br.com.souzaos.souzaOs.model.Client;
import br.com.souzaos.souzaOs.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServices {
    private final ClientRepository repository;


    public ClientServices(ClientRepository repository) {
        this.repository = repository;
    }

    public Client findById(String id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client save(Client client) {
        return repository.save(client);
    }


}
