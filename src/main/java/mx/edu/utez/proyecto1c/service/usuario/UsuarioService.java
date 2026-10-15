package mx.edu.utez.proyecto1c.service.usuario;

import jakarta.transaction.Transactional;
import mx.edu.utez.proyecto1c.controller.dto.RequestCrearUsuarioDTO;
import mx.edu.utez.proyecto1c.exception.customExceptions.BadRequestException;
import mx.edu.utez.proyecto1c.model.persona.Persona;
import mx.edu.utez.proyecto1c.model.usuario.Roles;
import mx.edu.utez.proyecto1c.model.usuario.Usuario;
import mx.edu.utez.proyecto1c.repository.persona.PersonaRepository;
import mx.edu.utez.proyecto1c.repository.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PersonaRepository personaRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PersonaRepository personaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.personaRepository = personaRepository;
    }


    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario createUsuario(RequestCrearUsuarioDTO payload){

        if(usuarioRepository.findByUsername(payload.getUsername()).isPresent()){
            throw new BadRequestException("El usuario ya existe");
        }
        //registrar Persona
        Persona newPersona = new Persona();
        newPersona.setNombre(payload.getNombres());
        newPersona.setPrimerApellido(payload.getPrimerApellido());
        newPersona.setSegundoApellido(payload.getSegundoApellido());
        newPersona.setEmail(payload.getCorreo());
        newPersona.setCurp(payload.getCurp());
        newPersona.setFechaNacimiento(payload.getFechaNacimiento());

        newPersona = personaRepository.save(newPersona);

        //Crear instancia de usuario y llenarla en base a la info de lpayload
        Usuario newUser = new Usuario();

        newUser.setUsername(payload.getUsername());
        newUser.setPassword(payload.getPassword());
        newUser.setDescripcion(payload.getDescripcion());
        newUser.setEnable(true);
        newUser.setRol(
                Roles.valueOf(payload.getRol())
        );

        newUser.setPersona(newPersona);
        return usuarioRepository.save(newUser);
    }
}