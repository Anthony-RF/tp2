package tec.lp.tp2.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "Medico")
@ToString @EqualsAndHashCode
public class Medico extends Persona{

    @Id
    @Setter @Getter @Column(name = "cedula")
    private String cedula;

    @Setter @Getter @Column(name = "nombre")
    private String nombre;

    @Setter @Getter @Column(name = "apellido")
    private String apellido;

    @Setter @Getter @Column(name = "correo")
    private String correo;

    @Setter @Getter @Column(name = "identificador")
    private int identificador;

    @Setter @Getter @Column(name = "especialidad")
    private String especialidad;

}

