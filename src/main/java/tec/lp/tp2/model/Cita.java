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
}
