package com.java.flexilab.configSecurity.service;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.java.flexilab.configSecurity.model.Rol;
import com.java.flexilab.configSecurity.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Implementación de UserDetails para la autenticación y autorización de usuarios.
 */
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final User user;

    /**
     * Devuelve una colección de GrantedAuthority que representa los roles del user.
     *
     * @return Una colección de GrantedAuthority que representa los roles del user.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Rol> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Rol rol : roles)
            authorities.add(new SimpleGrantedAuthority(rol.getNombre()));

        return authorities;
    }

    /**
     * Obtiene la contraseña del user.
     *
     * @return La contraseña del user.
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Obtiene el nombre de user del user.
     *
     * @return El nombre de user del user.
     */
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    /**
     * Obtiene el nombre del user.
     *
     * @return El nombre del user.
     */
    public String getName() {
        return user.getNombre();
    }

    /**
     * Indica si la cuenta del user ha expirado.
     *
     * @return true si la cuenta no ha expirado, false de lo contrario.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indica si la cuenta del user está bloqueada.
     *
     * @return true si la cuenta no está bloqueada, false de lo contrario.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    /**
     * Indica si las credenciales del user han expirado.
     *
     * @return true si las credenciales no han expirado, false de lo contrario.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indica si el user está habilitado.
     *
     * @return true si el user está habilitado, false de lo contrario.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}