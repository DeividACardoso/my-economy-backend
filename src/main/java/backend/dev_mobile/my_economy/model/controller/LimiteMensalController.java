package backend.dev_mobile.my_economy.model.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import backend.dev_mobile.my_economy.model.entity.LimiteMensal;
import backend.dev_mobile.my_economy.model.exceptions.BadInputsException;
import backend.dev_mobile.my_economy.service.LimiteMensalService;

@Controller
@RequestMapping("/api/limite-mensal")
@CrossOrigin(origins = {"http://localhost:8081","exp://192.168.0.16:8081","http://localhost:9000"}, maxAge = 3600)
public class LimiteMensalController {
    @Autowired
    LimiteMensalService limiteMensalService;

    @PostMapping("/salvar")
    public LimiteMensal criarLimiteMensal(@RequestBody LimiteMensal limite){
        System.out.println(limite.getReferenciaMes());
        return limiteMensalService.criarLimiteMensal(limite);
    }

    @GetMapping("/listar-limite")
    public Optional<LimiteMensal> getLimiteMensal(@RequestBody LimiteMensal limiteMensal){
        return limiteMensalService.getLimiteMensal(limiteMensal.getUsuarioEmail(), limiteMensal.getReferenciaMes());
    }
    
    @DeleteMapping("/delete/{id}")
	public boolean excluir(@PathVariable Integer id) {
		boolean excluiu = limiteMensalService.excluir(id);
		return excluiu;
	}
    
    @PutMapping(path = "/atualizar/{id}")
	public LimiteMensal atualizar(@PathVariable Integer id, @RequestBody LimiteMensal limiteAtualizar)
			throws BadInputsException {
		return limiteMensalService.atualizar(id, limiteAtualizar);
	}
    
}   
