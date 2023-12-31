package tec.lp.tp2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Persona")
public class Persona {

    private static int cantidadPascientes;
    private static int cantidadMedicos;

    @Setter @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cedula")
    private int cedula;

    @Getter @Setter
    @Column(name = "nombre")
    private String nombre;

    @Getter @Setter
    @Column(name = "apellido")
    private String apellido;

    @Getter @Setter
    @Column(name = "correo", unique = true)
    private String correo;
}
