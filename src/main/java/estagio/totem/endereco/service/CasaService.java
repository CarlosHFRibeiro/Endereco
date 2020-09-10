package estagio.totem.endereco.service;

import estagio.totem.endereco.entity.Casa;
import estagio.totem.endereco.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CasaService {
    private final CasaRepository casaRepository;

    @Autowired
    public CasaService(CasaRepository casaRepository) {
        this.casaRepository = casaRepository;
    }

    public Casa selectById(Long idCasa) {
        return casaRepository.findById(idCasa).orElseThrow();
    }

    public Casa save(Casa casa) {
        return casaRepository.save(casa);
    }

}
