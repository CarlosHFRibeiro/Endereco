package estagio.totem.endereco.service;

import estagio.totem.endereco.entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AutentificacaoService implements UserDetailsService {
    private final UsuarioService usuarioService;
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    @Autowired
    public AutentificacaoService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioService.selectByEmail(username);
    }

    public String getToken(UsernamePasswordAuthenticationToken login) {
        Usuario usuario = usuarioService.selectByEmail(login.getPrincipal().toString());

        Date dtHj = new Date();
        Date dtExpira = new Date(dtHj.getTime() + Long.parseLong(expiration));

        return Jwts.builder().setIssuer("Endereco").setSubject(usuario.getIdUser().toString())
                .setIssuedAt(dtHj).claim("nomeUser", usuario.getNomeUser()).setExpiration(dtExpira)
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public boolean isTokenValid(String token) {
        if (token != null) {
            try {
                Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
        return false;
    }

    public Long getIdUsuario(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }
}
