package br.com.souzaos.souzaOs.controller;

import br.com.souzaos.souzaOs.model.Client;
import br.com.souzaos.souzaOs.services.ClientServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    private final ClientServices clientServices;

    public ClientsController(ClientServices clientServices) {
        this.clientServices = clientServices;
    }

    @PostMapping
    public Client create(@RequestBody Client client) {
        return  clientServices.save(client);
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable String id) {
        return clientServices.findById(id);
    }

    @GetMapping
    public List<Client> findAll() {
        return clientServices.findAll();
    }

}
