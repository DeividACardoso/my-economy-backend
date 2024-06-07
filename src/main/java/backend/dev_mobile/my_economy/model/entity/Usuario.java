package backend.dev_mobile.my_economy.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuario {

    @Id
    private String email;
    private String nome;
    private String password;
    private LocalDate dtNascimento;

}
