package br.com.souzaos.souzaOs.controller;

import br.com.souzaos.souzaOs.dto.ResponseClientDTO;
import br.com.souzaos.souzaOs.model.Client;
import br.com.souzaos.souzaOs.model.User;
import br.com.souzaos.souzaOs.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {


    private final ClientRepository repository;



    @PostMapping
    public ResponseEntity createClient(@RequestBody Client client) {

        Client newClient = new Client();

        User loggedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        newClient.setName(client.getName());
        newClient.setPhoneNumber(client.getPhoneNumber());
        newClient.setTenantId(loggedUser.getTenantId());

        this.repository.save(newClient);
        return ResponseEntity.ok(new ResponseClientDTO(newClient.getName(), newClient.getPhoneNumber(), newClient.getTenantId(), newClient.getCreatedAt(), newClient.getWorkOrders()));

    }

    @GetMapping
    public ResponseEntity getAllClients() {
        User loggedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Client> clients = this.repository.findAll();
        return clients.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(clients);
    }





}
