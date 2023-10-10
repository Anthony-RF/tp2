package tec.lp.tp2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;
import java.util.List;

@Entity
@Table(name = "Persona")
public abstract class Persona {

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
    @Column(name = "tipo")
    private TinyIntJdbcType tipo;

    @Getter @Setter
    @OneToOne(mappedBy = "persona")
    private Medico medico;

    @Getter @Setter
    @OneToMany(mappedBy = "persona")
    private List<Cita> citas;

}
