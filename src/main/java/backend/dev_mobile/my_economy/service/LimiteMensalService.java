package backend.dev_mobile.my_economy.service;

import java.time.YearMonth;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dev_mobile.my_economy.model.entity.LimiteMensal;
import backend.dev_mobile.my_economy.repository.LimiteMensalRepository;

@Service
public class LimiteMensalService {

    @Autowired
    private LimiteMensalRepository limiteMensalRepository;

    // public LimiteMensal createMonthlyLimit(LimiteMensal limite) {
    //     YearMonth currentMonth = YearMonth.now();
    //     if (limite.getReferenciaMes().isBefore(currentMonth)) {
    //         throw new IllegalArgumentException("Cannot create limits for past months");
    //     }
    //     if (limiteMensalRepository.findByUsuarioEmailAndReferenciaMes(limite.getUsuarioEmail(), limite.getReferenciaMes())
    //             .isPresent()) {
    //         throw new IllegalArgumentException("Limit already set for this month");
    //     }
    //     return limiteMensalRepository.save(limite);
    // }

    public Optional<LimiteMensal> getMonthlyLimit(String email, YearMonth month) {
        return limiteMensalRepository.findByUsuarioEmailAndReferenciaMes(email, month);
    }
}
