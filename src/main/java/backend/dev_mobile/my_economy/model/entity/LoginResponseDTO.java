package backend.dev_mobile.my_economy.model.entity;

import java.time.LocalDate;

public record LoginResponseDTO(String token, String nome, LocalDate dtNascimento) {
    
}
