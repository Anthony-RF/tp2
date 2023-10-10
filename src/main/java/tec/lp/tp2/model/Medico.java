package tec.lp.tp2.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "Medico")
@ToString
public class Medico extends Persona{

    @Id
    @Setter @Getter
    @Column(name = "identificador")
    private int identificador;

    @Setter @Getter
    @Column(name = "especialidad")
    private String especialidad;

    @Setter @Getter
    @Column(name = "cedula_Persona")
    private String cedula_Persona;

}

