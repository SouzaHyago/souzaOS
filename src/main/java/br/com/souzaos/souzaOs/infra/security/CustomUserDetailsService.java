package br.com.souzaos.souzaOs.infra.security;

import br.com.souzaos.souzaOs.model.User;
import br.com.souzaos.souzaOs.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomUserDetailsService {

    private final UserRepository repository;

    public User loadUserByUsername(String username) {
        return repository.findByEmail(username)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
