package com.java.flexilab.controllers;


import com.java.flexilab.DTO.SumarVisitaDTO;
import com.java.flexilab.entities.sistem.EnumNivel;
import com.java.flexilab.entities.sistem.Clases;
import com.java.flexilab.services.ClasesServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/clases")
public class ClasesController extends BaseControllerImpl<Clases, ClasesServiceImpl> {
/* FILTRADO FUNCIONANDO DE CATEGORIA Y NIVEL
    @GetMapping(path = {"/filtrar","/filtrar/"})
    public ResponseEntity<?> buscar(@RequestParam(required = false) String categoria,
                                         @RequestParam(required = false) String nivel,
                                         @PageableDefault(size = 20) Pageable pageable) {
        try {
            if (categoria != null && nivel != null) {
                try {
                    EnumNivel enumNivel = EnumNivel.valueOf(nivel.toUpperCase());
                    return ResponseEntity.status(HttpStatus.OK).body(service.findByCategoriaAndNivel(categoria, enumNivel, pageable));
                } catch (Exception e) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo encontrar el enum");
                }
            } else if (categoria != null) {
                return ResponseEntity.status(HttpStatus.OK).body(service.findByCategoria(categoria, pageable));
            } else if (nivel != null) {
                try {
                    EnumNivel enumNivel = EnumNivel.valueOf(nivel.toUpperCase());
                    return ResponseEntity.status(HttpStatus.OK).body(service.findByNivel(enumNivel, pageable));
                } catch (Exception e) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo encontrar el enum");
                }
            } else{
                return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ocurrio un error al buscar el producto");
        }
    }
*/
    @GetMapping(path = {"/filtrar","/filtrar/"})
    public ResponseEntity<?> buscar(
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String nivel,
            @PageableDefault(size = 20) Pageable pageable) {
        try {
            EnumNivel enumNivel = null;

            if (nivel != null) {
                enumNivel = EnumNivel.valueOf(nivel.toUpperCase());
            }

            if (categoria != null) {
                if (enumNivel != null) {
                    return ResponseEntity.status(HttpStatus.OK).body(service.findByCategoriaAndNivel(categoria, enumNivel, pageable));
                } else {
                    return ResponseEntity.status(HttpStatus.OK).body(service.findByCategoria(categoria, pageable));
                }
            } else if (enumNivel != null) {
                return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
            }

            // Agrega una declaración de retorno para manejar el caso en el que ninguna condición se cumpla
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo encontrar el enum");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ocurrió un error al buscar el producto");
        }
    }




    @PutMapping("/{id}/sumarVisita")
    public ResponseEntity<?> sumarVisita(@PathVariable Integer id, @RequestBody SumarVisitaDTO sumarVisitaDTO) {
        try {
            if (sumarVisitaDTO.isSumarVisita()) {
                Clases producto = service.findById(id);
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