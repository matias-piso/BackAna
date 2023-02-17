// Define el paquete donde se encuentra la clase
package com.java.flexilab.security;

// Importa la librería de Lombok para generar automáticamente los métodos getters y setters
import lombok.Getter;
import lombok.Setter;

// Define una clase llamada "AuthCredentials"
@Setter
@Getter
public class AuthCredentials {

    // Define dos campos privados para las credenciales de autenticación del usuario
    private String email;
    private String password;

    // El uso de las anotaciones "@Setter" y "@Getter" de Lombok generan automáticamente los métodos públicos para establecer y obtener los valores de los campos "email" y "password"

    // No es necesario escribir manualmente los métodos "setEmail()" y "setPassword()", ya que Lombok generará automáticamente estos métodos debido a la anotación "@Setter" en la clase

    // No es necesario escribir manualmente los métodos "getEmail()" y "getPassword()", ya que Lombok generará automáticamente estos métodos debido a la anotación "@Getter" en la clase
}
