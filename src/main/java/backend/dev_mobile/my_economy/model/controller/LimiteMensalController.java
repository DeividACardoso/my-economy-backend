package backend.dev_mobile.my_economy.model.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import backend.dev_mobile.my_economy.model.entity.Despesa;
import backend.dev_mobile.my_economy.model.entity.LimiteMensal;
import backend.dev_mobile.my_economy.service.LimiteMensalService;

@Controller
@RequestMapping("/api/limite-mes")
@CrossOrigin(origins = { "http://localhost:8081", "exp://192.168.0.16:8081", "http://localhost:9000" }, maxAge = 3600)
public class LimiteMensalController {
    @Autowired
    LimiteMensalService limiteMensalService;

    @PostMapping("/salvar")
    public LimiteMensal criarLimiteMensal(@RequestBody LimiteMensal limite) {
        System.out.println(limite.getReferenciaMes());
        return limiteMensalService.criarLimiteMensal(limite);
    }

    @GetMapping("/listar-limite")
    public Optional<LimiteMensal> getLimiteMensal(@RequestBody LimiteMensal limiteMensal) {
        return limiteMensalService.getLimiteMensal(limiteMensal.getUsuarioEmail(), limiteMensal.getReferenciaMes());
    }

    @GetMapping("/progresso/{mes}")
    public double calcularProgressoLimite(@PathVariable("mes") String referenceMonth,
            @RequestBody LimiteMensal limiteMensal, @RequestBody Despesa despesa) {
        double limiteMensalValue = limiteMensal.getQuantidade();
        double despesaValue = despesa.getGasto();

        double progresso = (despesaValue / limiteMensalValue) * 100;
        return progresso;
    }

}
