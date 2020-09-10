package estagio.totem.endereco.service;

import estagio.totem.endereco.configuration.exception.NotFound;
import estagio.totem.endereco.entity.Usuario;
import estagio.totem.endereco.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario selectById(Long idUser) {
        return usuarioRepository.findByIdUser(idUser).orElseThrow(() -> new NotFound("Usuario"));
    }

    public Usuario selectByEmail(String emailUser) {
        return usuarioRepository.findByEmailUser(emailUser).orElseThrow(() -> new NotFound("Usuario"));
    }
}
