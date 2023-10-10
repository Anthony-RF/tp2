package tec.lp.tp2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Medico_Medico")
public class Medico_Medico {

    @Getter @Setter
    @Id
    @ManyToOne
    @JoinColumn(name = "id_Medico")
    private Medico medico;

    @Getter @Setter
    @Id
    @ManyToOne
    @JoinColumn(name = "id_Especialista")
    private Medico especialista;
}
