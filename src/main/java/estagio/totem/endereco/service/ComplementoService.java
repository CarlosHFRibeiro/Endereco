package estagio.totem.endereco.service;

import estagio.totem.endereco.configuration.exception.NotFound;
import estagio.totem.endereco.entity.Complemento;
import estagio.totem.endereco.repository.ComplementoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplementoService {
    private final ComplementoRepository complementoRepository;

    @Autowired
    public ComplementoService(ComplementoRepository complementoRepository) {
        this.complementoRepository = complementoRepository;
    }

    public Complemento selectById(Long id) {
        return complementoRepository.findById(id).orElseThrow(() -> new NotFound("Complemento"));
    }

    public Complemento save(Complemento complemento) {
        return complementoRepository.save(complemento);
    }
}
