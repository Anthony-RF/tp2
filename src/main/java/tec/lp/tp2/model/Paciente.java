package tec.lp.tp2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "Paciente")
public class Paciente extends Persona{

    @Id
    @Setter
    @Column(name = "cedula")
    private String cedula;

    @Setter @Column(name = "nombre")
    private String nombre;

    @Setter @Column(name = "apellido")
    private String apellido;

    @Setter @Column(name = "correo")
    private String correo;

}
