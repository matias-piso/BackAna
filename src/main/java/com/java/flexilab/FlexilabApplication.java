package com.java.flexilab;

import com.java.flexilab.entities.actors.Admin;
import com.java.flexilab.entities.sistem.Categoria;
import com.java.flexilab.entities.sistem.EnumNivel;
import com.java.flexilab.entities.sistem.EnumPack;
import com.java.flexilab.entities.sistem.Producto;
import com.java.flexilab.repositories.AdminRepo;
import com.java.flexilab.repositories.CategoriaRepo;
import com.java.flexilab.repositories.ProductoRepo;
import com.java.flexilab.services.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlexilabApplication {

	@Autowired
	ProductoRepo productoRepo;

	@Autowired
	AdminRepo adminRepo;

	@Autowired
	CategoriaRepo categoriaRepo;

	public static void main(String[] args) {
		SpringApplication.run(FlexilabApplication.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		return (args) -> {
			if (args.length > 0) {
				System.out.println("Hello " + args[0]);
			}

			Admin admin1 = new Admin("admin","123");
			admin1 = adminRepo.save(admin1);

			Categoria categoria1 = new Categoria("Categoria 1", "Descripción de la categoría 1", "url");
			categoria1 = categoriaRepo.save(categoria1);

			Producto producto1 = new Producto();
			producto1.setNombre("Producto 1");
			producto1.setDescripcion("Descripción del producto 1");
			producto1.setPrecioDolar(100);
			producto1.setPrecioPesos(2000);
			producto1.setPrecioEuros(90);
			producto1.setUrlFoto("https://media.glamour.mx/photos/642c5305347cb2132003b34a/16:9/w_1920,c_limit/yoga_y_estiramientos_diferencias.jpg");
			producto1.setNivel(EnumNivel.AVANZADO);
			producto1.setPack(EnumPack.PACK8);
			producto1.setCategoria(categoria1);
			producto1.setAdmin(admin1);
			productoRepo.save(producto1);

			Producto producto2 = new Producto();
			producto2.setNombre("Producto 2");
			producto2.setDescripcion("Descripción del producto 2");
			producto2.setPrecioDolar(100);
			producto2.setPrecioPesos(2000);
			producto2.setPrecioEuros(90);
			producto2.setUrlFoto("https://images.ecestaticos.com/gnBzw92jLNdX0ELHqXqKtdX71fM=/152x0:2173x1516/557x418/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2Ffde%2F466%2Ff01%2Ffde466f01483ddb15a4d6d9d9cdd97ad.jpg");
			producto2.setNivel(EnumNivel.INICIAL);
			producto2.setPack(EnumPack.PACK12);
			producto2.setCategoria(categoria1);
			producto2.setAdmin(admin1);
			productoRepo.save(producto2);

			// Agregar 10 productos más de prueba
			for (int i = 3; i <= 12; i++) {
				Producto producto = new Producto();
				producto.setNombre("Producto " + i);
				producto.setDescripcion("Descripción del producto " + i);
				producto.setPrecioDolar(100 * i);
				producto.setPrecioPesos(2000 * i);
				producto.setPrecioEuros(90 * i);
				producto.setUrlFoto("url_foto_producto_" + i);
				producto.setNivel(EnumNivel.INTERMEDIO);
				producto.setPack(EnumPack.PACK4);
				producto.setCategoria(categoria1);
				producto.setAdmin(admin1);
				productoRepo.save(producto);
			}

		};
	}
}
