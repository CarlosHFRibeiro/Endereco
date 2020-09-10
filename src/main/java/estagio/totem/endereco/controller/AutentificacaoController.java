package estagio.totem.endereco.controller;

import estagio.totem.endereco.controller.dto.LoginDTO;
import estagio.totem.endereco.controller.dto.TokenDTO;
import estagio.totem.endereco.service.AutentificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/entrar")
public class AutentificacaoController {
    private final AutentificacaoService autentificacaoService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AutentificacaoController(AutentificacaoService autentificacaoService, AuthenticationManager authenticationManager) {
        this.autentificacaoService = autentificacaoService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public ResponseEntity<TokenDTO> loginUSer(@RequestBody @Valid LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getSenha());
        authenticationManager.authenticate(login);
        TokenDTO tokenDTO=new TokenDTO("Bearer", autentificacaoService.getToken(login));
        return ResponseEntity.ok().body(tokenDTO);
    }
}
