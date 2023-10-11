package tec.lp.tp2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;


@Entity
@Table(name = "Medico")
@ToString
public class Medico extends Persona{

    @Getter @Setter
    @Column(name = "id")
    private int id;

    @Getter @Setter
    @Column(name = "especialidad")
    private String especialidad;

}

