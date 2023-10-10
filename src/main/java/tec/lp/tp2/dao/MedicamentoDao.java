package tec.lp.tp2.dao;

import tec.lp.tp2.model.Medicamento;

import java.util.List;

public interface MedicamentoDao {

        void createMedicamento(Medicamento medicamento);
        List<Medicamento> readAllMedicamento();
        Medicamento readByNombreMedicamento(String nombre);
        void updateMedicamento(Medicamento medicamento);
        void deleteMedicamento(String nombre);
}