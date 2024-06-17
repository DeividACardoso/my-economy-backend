package backend.dev_mobile.my_economy.model.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dev_mobile.my_economy.model.entity.LimiteMensal;
import backend.dev_mobile.my_economy.service.LimiteMensalService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/limite")
@CrossOrigin(origins = { "http://localhost:8081", "exp://192.168.100.30:8081", "http://localhost:9000" }, maxAge = 3600)
public class LimiteMensalController {

    @Autowired
    LimiteMensalService limiteMensalService;

    @GetMapping("/por-mes-e-login/{referenciaMes}/{login}")
    public List<LimiteMensal> getByReferenciaMesAndUsuarioEmail(@PathVariable("referenciaMes") LocalDate referenciaMes,
            @PathVariable("login") String usuarioEmail) {
                referenciaMes = referenciaMes.withDayOfMonth(1);
        return limiteMensalService.getByReferenciaMesAndUsuarioEmail(referenciaMes, usuarioEmail);
    }

    @GetMapping("/por-mes/{referenciaMes}")
    public List<LimiteMensal> listarLimitePorMes(@PathVariable("referenciaMes") LocalDate referenciaMes) {
        return limiteMensalService.getLimitesPorMes(referenciaMes);
    }

    @PostMapping("/salvar")
    public LimiteMensal salvar(@RequestBody LimiteMensal limite) {
        limite.setReferenciaMes(limite.getReferenciaMes().withDayOfMonth(1));
        return limiteMensalService.criarLimiteMensal(limite);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<Void> deletarLimite(@PathVariable Integer id) {
        limiteMensalService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar/{id}")
    public LimiteMensal atualizar(@PathVariable Integer id, @RequestBody LimiteMensal limite) {
        return limiteMensalService.atualizar(id, limite);
    }

    @GetMapping("/soma-por-mes/{referenciaMes}/{usuarioEmail}")
    public double somarLimitesPorMesEUsuario(@PathVariable("referenciaMes") LocalDate referenciaMes, @PathVariable("usuarioEmail") String usuarioEmail) {
        List<LimiteMensal> limites = limiteMensalService.getByReferenciaMesAndUsuarioEmail(referenciaMes, usuarioEmail);
        double total = 0.0;
        for (LimiteMensal limite : limites) {
            total += limite.getValor();
        }
        return total;
    }
}
