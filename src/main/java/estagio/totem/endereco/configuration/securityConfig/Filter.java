package estagio.totem.endereco.configuration.securityConfig;

import estagio.totem.endereco.entity.Usuario;
import estagio.totem.endereco.service.AutentificacaoService;
import estagio.totem.endereco.service.UsuarioService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Filter extends OncePerRequestFilter {
    private final AutentificacaoService autentificacaoService;
    private final UsuarioService usuarioService;

    public Filter(AutentificacaoService autentificacaoService, UsuarioService usuarioService) {
        this.autentificacaoService = autentificacaoService;
        this.usuarioService = usuarioService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recupearaToken(request);
        boolean isTokenValid = autentificacaoService.isTokenValid(token);
        if(isTokenValid){
            autenticarUsuario(token);
        }
        filterChain.doFilter(request, response);
    }

    private void autenticarUsuario(String token) {
        Long idUser = autentificacaoService.getIdUsuario(token);
        Usuario usuario = usuarioService.selectById(idUser);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(usuario,null,usuario.getPerfils());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    private String recupearaToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (isAuthorizationValid(token)) {
            return token.substring(7);
        }
        return null;
    }

    private boolean isAuthorizationValid(String token) {
        return token != null && !token.isEmpty() && token.startsWith("Bearer") && token.length() > 7;
    }
}
