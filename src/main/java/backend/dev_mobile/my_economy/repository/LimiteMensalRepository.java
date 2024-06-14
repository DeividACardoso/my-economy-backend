package backend.dev_mobile.my_economy.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.dev_mobile.my_economy.model.entity.LimiteMensal;

@Repository
public interface LimiteMensalRepository extends JpaRepository<LimiteMensal, Long> {
    Optional<LimiteMensal> findByUsuarioEmailAndReferenciaMes(String email, LocalDate mesReferencia);

	boolean existsById(Integer id);

	void deleteById(Integer id);

	Optional<LimiteMensal> findById(Integer id);
}