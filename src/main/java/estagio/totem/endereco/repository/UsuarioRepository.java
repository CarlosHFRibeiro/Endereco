package estagio.totem.endereco.repository;

import estagio.totem.endereco.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.perfils WHERE u.idUser = :idUser")
    Optional<Usuario> findByIdUser(Long idUser);

    Optional<Usuario>findByEmailUser(String email);
}
