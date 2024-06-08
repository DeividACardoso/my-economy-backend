package backend.dev_mobile.my_economy.model.entity;

import java.time.LocalDate;

public record RegisterDTO(
    String login,
    String nome,
    String password,
    UserRole role,
    LocalDate dtNascimento,
    Integer idDespesa,
    Integer idLimiteMensal
) {}

