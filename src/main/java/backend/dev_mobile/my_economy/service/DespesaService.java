package backend.dev_mobile.my_economy.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import backend.dev_mobile.my_economy.model.entity.Despesa;
import backend.dev_mobile.my_economy.repository.DespesaRepository;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa salvar(Despesa despesa) {
        despesa.setReferenciaMes(despesa.getReferenciaMes().withDayOfMonth(1));
        return despesaRepository.save(despesa);
    }

    public List<Despesa> getDespesasPorMes(LocalDate referenciaMes) {
        return despesaRepository.getByReferenciaMes(referenciaMes);
    }

    public List<Despesa> getByUsuarioEmail(String login) {
        return despesaRepository.getByUsuarioEmail(login);
    }

    public void deletarDespesa(Long id) {
        despesaRepository.deleteById(id);
    }

    public List<Despesa> getByReferenciaMesAndUsuarioEmail(@PathVariable("referenciaMes") LocalDate referenciaMes,
            @PathVariable("login") String usuarioEmail) {
        referenciaMes = referenciaMes.withDayOfMonth(1);
        return despesaRepository.getByReferenciaMesAndUsuarioEmail(referenciaMes, usuarioEmail);
    }

    public Despesa atualizar(Long id, Despesa despesa) {
        Despesa despesaParaAtualizar = despesaRepository.findById(id).get();
        System.out.println(despesaParaAtualizar);

        despesaParaAtualizar.setDescricao(despesa.getDescricao());
        despesaParaAtualizar.setGasto(despesa.getGasto());

        System.out.println(despesaParaAtualizar);

        return despesaRepository.save(despesaParaAtualizar);
    }
}
