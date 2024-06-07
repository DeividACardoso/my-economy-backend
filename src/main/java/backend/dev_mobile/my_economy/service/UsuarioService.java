package backend.dev_mobile.my_economy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import backend.dev_mobile.my_economy.model.entity.Usuario;
import backend.dev_mobile.my_economy.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario register(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getEmail())) {
            throw new RuntimeException("Email já existe");
        }
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public Usuario login(String email, String password) {
        Usuario usuario = usuarioRepository.findById(email)
                .orElseThrow(() -> new RuntimeException("Usuário não foi encontrado"));
        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new RuntimeException("Senha inválida");
        }
        return usuario;
    }
}

