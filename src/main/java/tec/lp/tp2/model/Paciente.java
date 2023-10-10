package tec.lp.tp2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@DiscriminatorValue("0")
@ToString
public class Paciente extends Persona{

    private static int cantidad;
    private List<Medicamento> tratamiento;

    public List<Medicamento> getTratamiento(){
        for (Cita cita : this.getCitas()){
            tratamiento.add((Medicamento) cita.getMedicamentos());
        }
        return tratamiento;
    }

}
