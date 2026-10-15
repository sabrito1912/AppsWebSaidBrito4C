package mx.edu.utez.proyecto1c.controller.usuario;


import jakarta.validation.Valid;
import mx.edu.utez.proyecto1c.controller.dto.RequestCrearUsuarioDTO;
import mx.edu.utez.proyecto1c.model.usuario.Usuario;
import mx.edu.utez.proyecto1c.service.usuario.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin({"*"})
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers(){
        return ResponseEntity
                .status(200)
                .body(
                        this.usuarioService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody @Valid RequestCrearUsuarioDTO payload){
        return ResponseEntity
                .status(201)
                .body(
                        this.usuarioService.createUsuario(payload)
                );
    }
}
