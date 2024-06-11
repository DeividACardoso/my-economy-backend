package backend.dev_mobile.my_economy.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dev_mobile.my_economy.model.entity.LimiteMensal;
import backend.dev_mobile.my_economy.repository.LimiteMensalRepository;

@Service
public class LimiteMensalService {

    @Autowired
    private LimiteMensalRepository limiteMensalRepository;

    public LimiteMensal criarLimiteMensal(LimiteMensal limite) {
        LocalDate currentMonth = LocalDate.now().withDayOfMonth(01);
        if (limite.getReferenciaMes().isBefore(currentMonth)) {
            throw new IllegalArgumentException("Não é possivel criar limites para meses que já passaram.");
        }
        if (limiteMensalRepository.findByUsuarioEmailAndReferenciaMes(limite.getUsuarioEmail(), limite.getReferenciaMes())
                .isPresent()) {
            throw new IllegalArgumentException("Limite para este mês já foi gerado.");
        }
        return limiteMensalRepository.save(limite);
    }

    public Optional<LimiteMensal> getLimiteMensal(String email, LocalDate month) {
        return limiteMensalRepository.findByUsuarioEmailAndReferenciaMes(email, month);
    }
}
