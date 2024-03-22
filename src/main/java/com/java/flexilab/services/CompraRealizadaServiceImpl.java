package com.java.flexilab.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.java.flexilab.DTO.*;
import com.java.flexilab.configSecurity.config.TokenUtils;
import com.java.flexilab.entities.actors.Usuarios;
import com.java.flexilab.entities.sistem.*;
import com.java.flexilab.interfaces.CompraRealizadaService;
import com.java.flexilab.repositories.BaseRepository;
import com.java.flexilab.repositories.ClaseCantidadDTORepo;
import com.java.flexilab.repositories.CompraRealizadaRepo;
import com.java.flexilab.repositories.HorarioClaseRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CompraRealizadaServiceImpl extends BaseServiceImpl<CompraRealizada, Integer> implements CompraRealizadaService {

    @Autowired
    private CompraRealizadaRepo compraRealizadaRepo;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private ClasesServiceImpl claseService;

    @Autowired
    private ProductoServiceImpl productoService;

    @Autowired
    private ClaseCantidadDTORepo claseCantidadDTORepo;

    @Autowired
    private HorarioClaseRepo horarioClaseRepo;


    public CompraRealizadaServiceImpl(BaseRepository<CompraRealizada, Integer> baseRepository) {
        super(baseRepository);
    }

    public Usuarios save(CompraRealizadaDTO compraRealizadaDTO, Integer idUsuario, HttpServletRequest request) throws Exception {
        try {
            verificarUsuario(idUsuario, request);

            ObjectMapper mapper = new ObjectMapper();

            System.out.println("Compra realizada: " + mapper.writeValueAsString(compraRealizadaDTO));
            CompraRealizada compraRealizada = new CompraRealizada();

            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Precio total: " + compraRealizadaDTO.getPrecio());

            compraRealizada.setPrecio(compraRealizadaDTO.getPrecio());
            compraRealizada.setMetodoPago(EnumMetodoPago.valueOf(compraRealizadaDTO.getMetodoPago()));
            compraRealizada.setEstado(EnumEstadoCompra.valueOf(compraRealizadaDTO.getEstado()));

            if (compraRealizada.getMetodoPago() == null) {
                throw new Exception("El metodo de pago no compatible");
            }

            List<ClaseCantidadDTO> clasesList = convertirClaseDTOAClase(compraRealizadaDTO.getClases());
            System.out.println("Clases: " + mapper.writeValueAsString(clasesList));
            List<Producto> productosList = converitrProductoDTOAProducto(compraRealizadaDTO.getProductos());

            compraRealizada.addClases(clasesList);
            compraRealizada.addProductos(productosList);

            compraRealizada = compraRealizadaRepo.save(compraRealizada);

            return usuarioService.addCompraRealizada(idUsuario, compraRealizada);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    public List<ClaseCantidadDTO> convertirClaseDTOAClase(List<ClaseDTOpost> clasesDTOpost) throws Exception {
        // Crear un ObjectMapper y registrar el módulo JavaTimeModule
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        List<ClaseCantidadDTO> clasesL = new ArrayList<>();
        for (ClaseDTOpost claseDTOpost : clasesDTOpost) {
            // Realizar la conversión de ClaseDTO a Clase
            Clases clase = claseService.findById(claseDTOpost.getClaseId());
            ClaseCantidadDTO claseDTO = new ClaseCantidadDTO();
            claseDTO.setClase(clase);

            claseDTO.setCantidadDisponible(claseDTOpost.getCantidadDisponible());
            HorarioClase hrCl = horarioClaseRepo.findById(claseDTOpost.getDiaHorarioClaseId()).get();
            claseDTO.setDiaHorarioClase(hrCl);

            claseDTO = claseCantidadDTORepo.save(claseDTO);

            clasesL.add(claseDTO);
        }
        return clasesL;
    }

    public List<Producto> converitrProductoDTOAProducto(List<Integer> productosId) throws Exception {
        List<Producto> productosL = new ArrayList<>();
        for (Integer productoId : productosId) {
            // Realizar la conversión de ProductoDTO a Producto
            Producto producto = productoService.findById(productoId);
            productosL.add(producto);
        }
        return productosL;
    }

    public Object getComprasRealizadas(Integer idUsuario, HttpServletRequest request) {
        try {
            verificarUsuario(idUsuario, request);
            Usuarios usuario = usuarioService.findById(idUsuario);
            // Obtener la lista de compras realizadas del usuario
            List<CompraRealizada> comprasRealizadas = usuario.getComprasRealizadas();
            // Ordenar las compras realizadas por fecha en orden descendente
            comprasRealizadas.sort(Comparator.comparing(CompraRealizada::getFecha).reversed());
            return comprasRealizadas;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    private void verificarUsuario(Integer idUsuario, HttpServletRequest request) throws Exception {

        // Obtener el token de la solicitud
        String token = request.getHeader("Authorization");

        // Verificar si el token está presente
        if (token == null || !token.startsWith("Bearer ")) {
            throw new RuntimeException("No tiene permisos para acceder a este recurso");
        }

        // Extraer el token de la cadena "Bearer token"
        token = token.substring(7);
        System.out.println("Token: " + token);
        // Obtener la autenticación a partir del token
        UsernamePasswordAuthenticationToken authentication = TokenUtils.getAutentication(token);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Authentication: " + mapper.writeValueAsString(authentication));
        // Obtener el email del usuario autenticado
        String email = (String) authentication.getPrincipal();
        System.out.println("Email: " + email);

        // Verificar si el email coincide con el usuario en el path
        if (!email.equals(usuarioService.findById(idUsuario).getUser().getEmail())) {
            throw new RuntimeException("No tiene permisos para acceder a este recurso");
        }
    }

    @Transactional
    public CompraRealizada updateCompraRealizada(CompraRealizadaDTOupdate compraRealizadaDTOupdate, Integer idCompraRealizada, HttpServletRequest request) throws Exception {
        try {
            // buscar la compra realizada
            CompraRealizada compraRealizadaDB = findById(idCompraRealizada);
            // modifico el estado de la compra realizada
            compraRealizadaDB.setEstado(EnumEstadoCompra.valueOf(compraRealizadaDTOupdate.getEstadoCompra()));
            // modifico la cantidad de clases disponibles de todas las clases
            List<ClaseCantidadDTO> clases = new ArrayList<>();
            for (ClaseDTOupdate clase : compraRealizadaDTOupdate.getClases()) {
                ClaseCantidadDTO claseCantidadDTO = claseCantidadDTORepo.findById(clase.getId()).get();
                claseCantidadDTO.setCantidadDisponible(clase.getCantidadDisponible());
                clases.add(claseCantidadDTO);
            }
            compraRealizadaDB.setClases(clases);
            return save(compraRealizadaDB);
            //return null;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
