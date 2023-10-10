package tec.lp.tp2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Persona")
public abstract class Persona {

    @Id
    @Setter @Getter
    @Column(name = "cedula")
    private int cedula;

    @Setter @Getter
    @Column(name = "nombre")
    private String nombre;

    @Setter @Getter
    @Column(name = "apellido")
    private String apellido;

    @Setter @Getter
    @Column(name = "correo")
    private String correo;

}
