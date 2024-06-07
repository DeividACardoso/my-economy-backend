package backend.dev_mobile.my_economy.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String nome;
    private String senha;
    private LocalDate dtNascimento;
    private Integer idDespesa;
    private Integer idLimiteMensal;
}
