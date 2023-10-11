package tec.lp.tp2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tec.lp.tp2.Repository.MedicamentoRepository;
import tec.lp.tp2.model.Medicamento;
import java.util.List;

@Controller
@RequestMapping("/medicamentos")
public class MedicamentoController {

    private final MedicamentoRepository medicamentoRepository;

    @Autowired
    public MedicamentoController(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    @GetMapping
    public String listMedicamentos(Model model) {
        List<Medicamento> medicamentos = medicamentoRepository.readAll();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("medicamento", new Medicamento());
        return "medicamentos/add";
    }

    @PostMapping("/add")
    public String addMedicamento(@ModelAttribute Medicamento medicamento) {
        medicamentoRepository.create(medicamento);
        return "redirect:/medicamentos";
    }

    @GetMapping("/edit/{nombre}")
    public String showEditForm(@PathVariable String nombre, Model model) {
        Medicamento medicamento = medicamentoRepository.read(nombre);
        model.addAttribute("medicamento", medicamento);
        return "medicamentos/edit";
    }

    @PostMapping("/edit/{nombre}")
    public String updateMedicamento(@PathVariable String nombre, @ModelAttribute Medicamento medicamento) {
        medicamentoRepository.update(medicamento);
        return "redirect:/medicamentos";
    }

    @GetMapping("/delete/{nombre}")
    public String deleteMedicamento(@PathVariable String nombre) {
        medicamentoRepository.delete(nombre);
        return "redirect:/medicamentos";
    }
}
