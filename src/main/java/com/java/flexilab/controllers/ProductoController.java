package com.java.flexilab.controllers;


import com.java.flexilab.DTO.SumarVisitaDTO;
import com.java.flexilab.entities.sistem.Producto;
import com.java.flexilab.services.ProductoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/productos")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl> {

    @PutMapping("/{id}/sumarVisita")
    public ResponseEntity<?> sumarVisita(@PathVariable Integer id, @RequestBody SumarVisitaDTO sumarVisitaDTO) {
        try {
            if (sumarVisitaDTO.isSumarVisita()) {
                Producto producto = service.findById(id);
                producto.sumarVisita();
                service.save(producto);
                return ResponseEntity.status(HttpStatus.OK).body("Visita sumada");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo sumar la visita");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo sumar la visita");
        }
    }
}