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

import backend.dev_mobile.my_economy.model.entity.Despesa;
import backend.dev_mobile.my_economy.service.DespesaService;

@RestController
@RequestMapping("/api/despesas")
@CrossOrigin(origins = { "http://localhost:8081", "exp://192.168.100.30:8081", "http://localhost:9000" }, maxAge = 3600)
public class DespesaController {

    @Autowired
    DespesaService despesaService;

    @GetMapping("/por-mes-e-login/{referenciaMes}/{login}")
    public List<Despesa> getByReferenciaMesAndUsuarioEmail(@PathVariable("referenciaMes") LocalDate referenciaMes,
            @PathVariable("login") String usuarioEmail) {
                referenciaMes = referenciaMes.withDayOfMonth(1);
        return despesaService.getByReferenciaMesAndUsuarioEmail(referenciaMes, usuarioEmail);
    }

    @GetMapping("/por-mes/{referenciaMes}")
    public List<Despesa> listarDespesasPorMes(@PathVariable("referenciaMes") LocalDate referenciaMes) {
        return despesaService.getDespesasPorMes(referenciaMes);
    }

    @PostMapping("/salvar")
    public Despesa salvar(@RequestBody Despesa despesa) {
        despesa.setReferenciaMes(despesa.getReferenciaMes().withDayOfMonth(1));
        return despesaService.salvar(despesa);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarDespesa(@PathVariable Long id) {
        despesaService.deletarDespesa(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{login}")
    public List<Despesa> getByUsuarioEmail(@PathVariable String login) {
        return despesaService.getByUsuarioEmail(login);
    }

    @PutMapping("/atualizar/{id}")
    public Despesa atualizar(@PathVariable Long id, @RequestBody Despesa despesa) {
        return despesaService.atualizar(id, despesa);
    }

    @GetMapping("/soma-por-mes/{referenciaMes}/{usuarioEmail}")
    public double somarDespesasPorMesEUsuario(@PathVariable("referenciaMes") LocalDate referenciaMes, @PathVariable("usuarioEmail") String usuarioEmail) {
        List<Despesa> despesas = despesaService.getByReferenciaMesAndUsuarioEmail(referenciaMes, usuarioEmail);
        double total = 0.0;
        for (Despesa despesa : despesas) {
            total += despesa.getGasto();
        }
        return total;
    }
}
