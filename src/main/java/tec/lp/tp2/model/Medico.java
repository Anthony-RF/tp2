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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Getter @Setter
    @Column(name = "especialidad")
    private String especialidad;

    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    private Persona persona;

    @Getter @Setter
    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

    @Getter @Setter
    @ManyToMany
    @JoinTable(
            name = "Medico_Medico",
            joinColumns = @JoinColumn(name = "id_Medico"),
            inverseJoinColumns = @JoinColumn(name = "id_Especialista")
    )
    private List<Medico> especialistas;

    @Getter @Setter
    @ManyToMany(mappedBy = "especialistas")
    private List<Medico> especialistasDe;

}

