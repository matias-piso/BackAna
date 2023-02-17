package com.java.flexilab.security;

import com.java.flexilab.entities.actors.Usuarios;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor //Lombok annotation que genera el constructor con todos los campos
public class UserDetailImpl implements UserDetails {

    private final Usuarios usuarios; //Instancia de la entidad Usuarios que representa al usuario de la aplicación

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); //Retorna una colección vacía de permisos
    }

    @Override
    public String getPassword() {
        return usuarios.getPassword(); //Retorna la contraseña del usuario
    }

    @Override
    public String getUsername() {
        return usuarios.getEmail(); //Retorna el email del usuario, que se usa como nombre de usuario
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; //Indica si la cuenta del usuario está expirada (en este caso, siempre es false)
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; //Indica si la cuenta del usuario está bloqueada (en este caso, siempre es false)
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; //Indica si las credenciales del usuario están expiradas (en este caso, siempre es false)
    }

    @Override
    public boolean isEnabled() {
        return true; //Indica si el usuario está habilitado (en este caso, siempre es true)
    }

    public String getNombre(){
        return usuarios.getNombre(); //Retorna el nombre del usuario, que se usa en algunos casos para personalizar la aplicación
    }
}
