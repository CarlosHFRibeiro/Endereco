package estagio.totem.endereco.repository;

import estagio.totem.endereco.entity.Complemento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplementoRepository extends JpaRepository<Complemento, Long> {
}
