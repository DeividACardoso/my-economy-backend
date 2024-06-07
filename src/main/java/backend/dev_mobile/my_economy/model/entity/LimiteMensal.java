package backend.dev_mobile.my_economy.model.entity;

import java.time.LocalDate;
import java.time.YearMonth;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class LimiteMensal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double quantidade;
    private LocalDate referenciaMes;
    private String usuarioEmail;

}
