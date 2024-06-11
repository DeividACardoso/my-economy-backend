package backend.dev_mobile.my_economy.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dev_mobile.my_economy.model.entity.Despesa;
import backend.dev_mobile.my_economy.repository.DespesaRepository;

@Service
public class DespesaService {
    
    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa salvar(Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    public List<Despesa> getDespesasPorMes(String usuarioEmail, LocalDate referenciaMes) {
        return despesaRepository.getByUsuarioEmailAndReferenciaMes(usuarioEmail, referenciaMes);
    }
}

