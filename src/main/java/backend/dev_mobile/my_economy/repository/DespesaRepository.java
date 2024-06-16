package backend.dev_mobile.my_economy.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.dev_mobile.my_economy.model.entity.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    List<Despesa> getByReferenciaMes(LocalDate referenciaMes);

    List<Despesa> getByUsuarioEmail(String email);

    List<Despesa> getByReferenciaMesAndUsuarioEmail(LocalDate referenciaMes, String usuarioEmail);

}