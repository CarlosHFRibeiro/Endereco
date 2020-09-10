package estagio.totem.endereco.service;

import estagio.totem.endereco.configuration.exception.NotFound;
import estagio.totem.endereco.entity.Bairro;
import estagio.totem.endereco.repository.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BairroService {
    private final BairroRepository bairroRepository;

    @Autowired
    public BairroService(BairroRepository bairroRepository) {
        this.bairroRepository = bairroRepository;
    }

    public Bairro selectById(Long id) {
        return bairroRepository.findById(id).orElseThrow(() -> new NotFound("Bairro"));
    }
}
