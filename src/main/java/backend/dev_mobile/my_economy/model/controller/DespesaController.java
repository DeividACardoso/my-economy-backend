package backend.dev_mobile.my_economy.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dev_mobile.my_economy.model.entity.Despesa;
import backend.dev_mobile.my_economy.service.DespesaService;


@RestController
@RequestMapping("/api/despesas")
@CrossOrigin(origins = { "http://localhost:8081", "exp://192.168.0.16:8081", "http://localhost:9000" }, maxAge = 3600)
public class DespesaController {

    @Autowired
    DespesaService despesaService;

    @GetMapping("/por-mes")
    public List<Despesa> listarDespesasPorMes(@RequestBody Despesa despesa) {
        return despesaService.getDespesasPorMes(despesa.getUsuarioEmail(), despesa.getReferenciaMes());
    }

    @PostMapping("/salvar")
    public Despesa salvar(@RequestBody Despesa despesa) {
        return despesaService.salvar(despesa);
    }

    //     @PutMapping("/{id}")
    // public ResponseEntity<Despesa> updateExpense(@PathVariable Long id, @RequestBody Despesa despesa, @AuthenticationPrincipal UserDetails userDetails) {
    //     YearMonth currentMonth = YearMonth.now();
    //     if (despesa.getReferenciaMes().isBefore(currentMonth)) {
    //         return ResponseEntity.badRequest().body(null);
    //     }
    //     Despesa updatedExpense = despesaService.updateExpense(id, despesa);
    //     return ResponseEntity.ok(updatedExpense);
    // }
    
}
