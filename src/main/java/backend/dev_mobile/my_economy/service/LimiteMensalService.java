package backend.dev_mobile.my_economy.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import backend.dev_mobile.my_economy.model.entity.Despesa;
import backend.dev_mobile.my_economy.model.entity.LimiteMensal;
import backend.dev_mobile.my_economy.repository.LimiteMensalRepository;

@Service
public class LimiteMensalService {

	@Autowired
	private LimiteMensalRepository limiteMensalRepository;

	public LimiteMensal salvarLimite(LimiteMensal limite) {
		limite.setReferenciaMes(limite.getReferenciaMes().withDayOfMonth(1));
		return limiteMensalRepository.save(limite);
	}

	public Optional<LimiteMensal> getLimiteMensal(String email, LocalDate month) {
		return limiteMensalRepository.findByUsuarioEmailAndReferenciaMes(email, month);
	}

	public LimiteMensal atualizar(Integer id, LimiteMensal limiteAtualizar) {
		LimiteMensal limiteAtualizado = findById(id);
		limiteAtualizado.setValor(limiteAtualizar.getValor());
		limiteAtualizado.setReferenciaMes(limiteAtualizar.getReferenciaMes());
		return limiteMensalRepository.save(limiteAtualizar);
	}

	public boolean excluir(Integer id) {
		boolean excluiu = false;
		if (limiteMensalRepository.existsById(id)) {
			limiteMensalRepository.deleteById(id);
			excluiu = true;
		}
		return excluiu;
	}

	private LimiteMensal findById(Integer id) {
		return limiteMensalRepository.findById(id).get();
	}

	public List<LimiteMensal> getByReferenciaMesAndUsuarioEmail(@PathVariable("referenciaMes") LocalDate referenciaMes,
            @PathVariable("login") String usuarioEmail) {
        referenciaMes = referenciaMes.withDayOfMonth(1);
        return limiteMensalRepository.getByReferenciaMesAndUsuarioEmail(referenciaMes, usuarioEmail);
    }

	public List<LimiteMensal> getDespesasPorMes(LocalDate referenciaMes) {
        return limiteMensalRepository.getByReferenciaMes(referenciaMes);
    }

}
