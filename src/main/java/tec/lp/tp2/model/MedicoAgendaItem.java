package tec.lp.tp2.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class MedicoAgendaItem {

    @Getter @Setter
    private LocalDateTime fecha;

    @Getter @Setter
    private Persona paciente;


}
