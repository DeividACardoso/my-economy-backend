package backend.dev_mobile.my_economy.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dev_mobile.my_economy.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = {"http://localhost:8081","exp://192.168.0.16:8081","http://localhost:9000"}, maxAge = 3600)
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    
}
