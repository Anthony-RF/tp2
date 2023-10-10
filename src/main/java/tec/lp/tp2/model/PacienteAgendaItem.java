package tec.lp.tp2.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class PacienteAgendaItem {

    @Getter @Setter
    private LocalDateTime fecha;

    @Getter @Setter
    private Medico medico;

}
