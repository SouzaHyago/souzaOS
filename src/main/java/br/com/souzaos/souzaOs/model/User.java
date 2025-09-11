package br.com.souzaos.souzaOs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name  = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @Size(min = 8)
    @Column(nullable = false)
    private String password;

    private boolean active = true;

    @Column(nullable = false)
    private String tenantId;
}
