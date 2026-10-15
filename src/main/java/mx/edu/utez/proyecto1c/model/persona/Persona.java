package mx.edu.utez.proyecto1c.model.persona;


import jakarta.persistence.*;
import lombok.*;
import mx.edu.utez.proyecto1c.model.cursos.Curso;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="personas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    private String nombre;
    private String primerApellido;
    private String segundoApellido;


    private Date fechaNacimiento;
    private String email;
    private String curp;

    @ManyToMany
    @JoinTable(
            name="persona_curso",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos;

}
