package backend.dev_mobile.my_economy.service;

import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import backend.dev_mobile.my_economy.model.entity.Despesa;
import backend.dev_mobile.my_economy.repository.DespesaRepository;

@Service
@RequestMapping("/despesa")
public class DespesaService {
    
    @Autowired
    private DespesaRepository despesaRepository;

    @PostMapping("/salvar")
    public Despesa createExpense(Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    @GetMapping("/por-mes")
    public List<Despesa> getDespesasPorMes(String email, YearMonth month) {
        return despesaRepository.findByUsuarioEmailAndReferenciaMes(email, month);
    }
}

