package com.java.flexilab;

import com.java.flexilab.configSecurity.model.Rol;
import com.java.flexilab.configSecurity.repository.RolRepository;
import com.java.flexilab.entities.actors.Admin;
import com.java.flexilab.entities.sistem.*;
import com.java.flexilab.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class FlexilabApplication {

	@Autowired
	ClasesRepo clasesRepo;

	@Autowired
	AdminRepo adminRepo;

	@Autowired
	CategoriaRepo categoriaRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ProductoRepo productoRepo;

	@Autowired
	private CategoriaProductoRepo categoriaProductoRepo;

	@Autowired
	private RolRepository rolRepository;

	public static void main(String[] args) {
		SpringApplication.run(FlexilabApplication.class, args);
	}


	@Bean
	public CommandLineRunner init() {
		return (args) -> {
			if (args.length > 0) {
				System.out.println("Hello " + args[0]);
			}

			Rol rolProfe = new Rol("ROLE_PROFESOR", "Rol de profesor");
			rolRepository.save(rolProfe);

			Rol rolUser = new Rol("ROLE_USER", "Rol de usuario");
			rolRepository.save(rolUser);

			Admin admin1 = new Admin();
			admin1.setEmail("test@gmail.com");
			admin1.setPassword(passwordEncoder.encode("123"));
			admin1.setNombre("Admin 1");
			Set<Rol> roles = Set.of(new Rol("ROLE_ADMIN", "Rol de administrador"));
			admin1.setRoles(roles);

			admin1 = adminRepo.save(admin1);

			CategoriaProducto categoriaProducto1 = new CategoriaProducto("Categoria 1");
			CategoriaProducto categoriaProducto2 = new CategoriaProducto("Categoria 2");
			CategoriaProducto categoriaProducto3 = new CategoriaProducto("Categoria 3");
			categoriaProductoRepo.save(categoriaProducto1);
			categoriaProductoRepo.save(categoriaProducto2);
			categoriaProductoRepo.save(categoriaProducto3);
			
			Producto producto1 = new Producto("Producto 1", "Descripción del producto 1", 100, 2000, 90, "url_foto_producto_1", categoriaProducto1, admin1,"");
			productoRepo.save(producto1);
			Producto producto2 = new Producto("Producto 2", "Descripción del producto 2", 200, 4000, 180, "url_foto_producto_2", categoriaProducto2, admin1,"");
			productoRepo.save(producto2);
			Producto producto3 = new Producto("Producto 3", "Descripción del producto 3", 300, 6000, 270, "url_foto_producto_3", categoriaProducto3, admin1,"");
			productoRepo.save(producto3);


			Categoria categoria1 = new Categoria("Categoria 1", "Descripción de la categoría 1", "url");
			categoria1 = categoriaRepo.save(categoria1);

			Clases clase1 = new Clases();
			clase1.setNombre("Clase 1");
			clase1.setDescripcion("Descripción del producto 1");
			clase1.setPrecioDolar(100);
			clase1.setPrecioPesos(2000);
			clase1.setPrecioEuros(90);
			clase1.setUrlFoto("https://media.glamour.mx/photos/642c5305347cb2132003b34a/16:9/w_1920,c_limit/yoga_y_estiramientos_diferencias.jpg");
			clase1.setNivel(EnumNivel.AVANZADO);
			clase1.setCategoria(categoria1);
			clase1.setAdmin(admin1);
			clasesRepo.save(clase1);

			Clases clase2 = new Clases();
			clase2.setNombre("Clase 2");
			clase2.setDescripcion("Descripción del producto 2");
			clase2.setPrecioDolar(100);
			clase2.setPrecioPesos(2000);
			clase2.setPrecioEuros(90);
			clase2.setUrlFoto("https://images.ecestaticos.com/gnBzw92jLNdX0ELHqXqKtdX71fM=/152x0:2173x1516/557x418/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2Ffde%2F466%2Ff01%2Ffde466f01483ddb15a4d6d9d9cdd97ad.jpg");
			clase2.setNivel(EnumNivel.INICIAL);
			clase2.setCategoria(categoria1);
			clase2.setAdmin(admin1);
			clasesRepo.save(clase2);

			// Agregar 10 productos más de prueba
			for (int i = 3; i <= 15; i++) {
				Clases clase = new Clases();
				clase.setNombre("Clase " + i);
				clase.setDescripcion("Descripción del clase " + i);
				clase.setPrecioDolar(100 * i);
				clase.setPrecioPesos(2000 * i);
				clase.setPrecioEuros(90 * i);
				clase.setUrlFoto("url_foto_producto_" + i);
				clase.setNivel(EnumNivel.INTERMEDIO);
				clase.setCategoria(categoria1);
				clase.setAdmin(admin1);
				clasesRepo.save(clase);
			}

		};
	}



}
