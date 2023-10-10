package tec.lp.tp2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Entity
@Table(name = "Medicamento")
@ToString
public class Medicamento {

    @Getter @Setter
    @Id
    @Column(name = "nombre")
    private String nombre;

    @Getter @Setter
    @ManyToMany(mappedBy = "medicamentos")
    private List<Cita> citas;
}
