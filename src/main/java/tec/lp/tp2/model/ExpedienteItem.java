package tec.lp.tp2.model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

public class ExpedienteItem {

    @Getter @Setter
    private LocalDateTime fecha;

    @Getter @Setter
    private String padecimiento;

    @Getter @Setter
    private String procedimiento;

    @Getter @Setter
    private List<Medicamento> medicamentos;
}
