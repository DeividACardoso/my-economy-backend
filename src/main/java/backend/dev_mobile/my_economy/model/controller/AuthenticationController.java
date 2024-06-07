package backend.dev_mobile.my_economy.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dev_mobile.my_economy.model.entity.AuthenticationDTO;
import backend.dev_mobile.my_economy.model.entity.LoginResponseDTO;
import backend.dev_mobile.my_economy.model.entity.RegisterDTO;
import backend.dev_mobile.my_economy.model.entity.Usuario;
import backend.dev_mobile.my_economy.model.infra.security.TokenService;
import backend.dev_mobile.my_economy.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.GenerateToken((Usuario)auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.usuarioRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        Usuario usuario = new Usuario(data.login(), encryptedPassword, data.role());

        this.usuarioRepository.save(usuario);

        return ResponseEntity.ok().build();
    }
}
