package estagio.totem.endereco.service;

import estagio.totem.endereco.configuration.exception.NotFound;
import estagio.totem.endereco.entity.Cliente;
import estagio.totem.endereco.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Page<Cliente> selectAll(Pageable pageable){
        return clienteRepository.findAll(pageable);
    }

    public Cliente selectById(Long idCliente){
        return clienteRepository.findById(idCliente).orElseThrow(() -> new NotFound("nao Tem"));
    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
