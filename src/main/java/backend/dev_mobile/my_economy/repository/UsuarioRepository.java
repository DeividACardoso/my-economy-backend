package backend.dev_mobile.my_economy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import backend.dev_mobile.my_economy.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{


    UserDetails findByLogin(String login);

    Usuario getByLogin(String login);

    boolean existsByLogin(String login);

}
