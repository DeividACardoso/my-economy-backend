package backend.dev_mobile.my_economy.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private Double gasto;
    @Column(name = "referencia_mes")
    private LocalDate referenciaMes;
    @Column(name = "usuario_email")
    private String usuarioEmail;

}
