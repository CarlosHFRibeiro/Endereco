package estagio.totem.endereco.controller;

import estagio.totem.endereco.controller.dto.ClienteDTO;
import estagio.totem.endereco.controller.dto.ClienteFormDTO;
import estagio.totem.endereco.entity.Casa;
import estagio.totem.endereco.entity.Cliente;
import estagio.totem.endereco.service.BairroService;
import estagio.totem.endereco.service.CasaService;
import estagio.totem.endereco.service.ClienteService;
import estagio.totem.endereco.service.ComplementoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService clienteService;
    private final CasaService casaService;
    private final ComplementoService complementoService;
    private final BairroService bairroService;
    private final ModelMapper modelMapper;

    @Autowired
    public ClienteController(ClienteService clienteService, CasaService casaService, ComplementoService complementoService, BairroService bairroService, ModelMapper modelMapper) {
        this.clienteService = clienteService;
        this.casaService = casaService;
        this.complementoService = complementoService;
        this.bairroService = bairroService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<Page<ClienteDTO>> selectAll(Pageable pageable) {
        return ResponseEntity.ok().body(clienteService.selectAll(pageable).map(this::mapper));
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteDTO> selectById(@PathVariable Long idCliente) {
        return ResponseEntity.ok().body(mapper(clienteService.selectById(idCliente)));
    }

    @Transactional
    @PostMapping
    public ResponseEntity<ClienteDTO> save(@RequestBody @Valid ClienteFormDTO cliente) {
        Cliente newCliente = mapper(cliente);
        return ResponseEntity.ok().body(saveCliente(cliente, newCliente));
    }


    @Transactional
    @PutMapping("{id}")
    public ResponseEntity<ClienteDTO> update(@RequestBody @Valid ClienteFormDTO cliente, @PathVariable Long id) {
        Cliente newCliente = mapper(cliente);
        newCliente.setIdCliente(id);
        return ResponseEntity.ok().body(saveCliente(cliente, newCliente));
    }

    private void saveCasa(Casa casa) {
        casaService.save(casa);
        if (casa.getBairro() != null) {
            casa.setBairro(bairroService.selectById(casa.getBairro().getIdBairro()));
        }
    }

    private void atribuirCasa(ClienteFormDTO cliente, Cliente newCliente) {
        if (cliente.getCasa() != null && !cliente.getCasa().isEmpty()) {
            for (Casa casa : cliente.getCasa()) {
                newCliente.addCasa(casaService.selectById(casa.getIdCasa()));
            }
        }
    }

    private ClienteDTO mapper(Cliente cliente) {
        return modelMapper.map(cliente, ClienteDTO.class);
    }


    private Cliente mapper(ClienteFormDTO cliente) {
        return modelMapper.map(cliente, Cliente.class);
    }

    private ClienteDTO saveCliente(ClienteFormDTO cliente, Cliente newCliente) {
        for (Casa casa : cliente.getCasa()) {
            if (casa.getIdCasa() == null) {
                saveCasa(casa);
            }
            if (casa.getComplemento() != null) {
                casa.getComplemento().setCasa(casa);
                if (casa.getComplemento().getIdComplemento() == null) {
                    complementoService.save(casa.getComplemento());
                }
            }
        }
        atribuirCasa(cliente, newCliente);
        return mapper(clienteService.save(newCliente));
    }
}
