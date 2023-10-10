package tec.lp.tp2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Cita")
@ToString
public class Cita {

    @Getter @Setter
    @Id
    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Getter @Setter
    @Column(name = "padecimiento")
    private String padecimiento;

    @Getter @Setter
    @Column(name = "procedimiento")
    private String procedimiento;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "cedula_Persona", referencedColumnName = "cedula")
    private Persona persona;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "id_Medico")
    private Medico medico;

    @Getter @Setter
    @ManyToMany
    @JoinTable(
            name = "Medicamento_Cita",
            joinColumns = @JoinColumn(name = "fecha_Cita"),
            inverseJoinColumns = @JoinColumn(name = "nombre_Medicamento")
    )
    private List<Medicamento> medicamentos;

}
