package backend.dev_mobile.my_economy.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dev_mobile.my_economy.model.entity.Usuario;
import backend.dev_mobile.my_economy.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/todos")
    public Iterable<Usuario> listarTodos(){
        return usuarioService.listarTodos();
    }
    
}
