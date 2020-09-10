package estagio.totem.endereco.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_usuario")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column
    private String nomeUser;

    @Column
    private String emailUser;

    @Column
    private String senhaUser;

    @ManyToMany
    @JoinTable(name = "tbl_perfil_user",
            joinColumns = @JoinColumn(name = "fkUser"),
            inverseJoinColumns = @JoinColumn(name = "fkPerfil"))
    private Set<Perfil> perfils;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getSenhaUser() {
        return senhaUser;
    }

    public void setSenhaUser(String senhaUser) {
        this.senhaUser = senhaUser;
    }

    public Set<Perfil> getPerfils() {
        if (perfils == null) {
            Collections.emptySet();
        }
        return perfils;
    }

    public void setPerfils(Perfil perfils) {
        if (this.perfils == null) {
            this.perfils = new HashSet<>();
        }
        this.perfils.add(perfils);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return perfils;
    }

    @Override
    public String getPassword() {
        return senhaUser;
    }

    @Override
    public String getUsername() {
        return emailUser;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
