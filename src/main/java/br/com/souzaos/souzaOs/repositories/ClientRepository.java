package br.com.souzaos.souzaOs.repositories;

import br.com.souzaos.souzaOs.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, String> {


}
