package tec.lp.tp2.Repository;

import tec.lp.tp2.model.Medicamento;

import java.util.List;

public interface MedicamentoRepositoryI {

    void create(Medicamento medicamento);

    Medicamento read(String nombre);

    void update(Medicamento medicamento);

    void delete(String nombre);

    List<Medicamento> readAll();
}
