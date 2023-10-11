package tec.lp.tp2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
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

    @Getter @Setter
    @OneToOne(mappedBy = "persona")
    private Medico medico;

    @Getter @Setter
    @OneToMany(mappedBy = "persona")
    private List<Cita> citas;

}
