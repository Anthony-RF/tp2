package tec.lp.tp2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;

@Entity
@Table(name = "Cita")
@ToString
public class Cita {

    @Id
    @Setter @Getter
    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Setter @Getter
    @Column(name = "Padecimiento")
    private String Padecimiento;

    @Setter @Getter
    @Column(name = "cedula_Paciente")
    private int cedula_Paciente;

    @Setter @Getter
    @Column(name = "cedula_Medico")
    private int cedula_Medico;

}
