package backend.dev_mobile.my_economy.service;

import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dev_mobile.my_economy.model.entity.Despesa;
import backend.dev_mobile.my_economy.repository.DespesaRepository;

@Service
public class DespesaService {
    
    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa createExpense(Despesa despesa) {
        YearMonth mesAtual = YearMonth.now();
        if (despesa.getReferenciaMes().isBefore(mesAtual)) {
            throw new IllegalArgumentException("Não é possível criar despesas para meses passados.");
        }
        return despesaRepository.save(despesa);
    }

    public List<Despesa> getDespesasPorMes(String email, YearMonth month) {
        return despesaRepository.findByUsuarioEmailAndReferenciaMes(email, month);
    }
}

