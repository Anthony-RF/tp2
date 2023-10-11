package tec.lp.tp2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tec.lp.tp2.Repository.MedicoRepository;
import tec.lp.tp2.model.Medico;
import java.util.List;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoRepository medicoRepository;

    @Autowired
    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @GetMapping
    public String listMedicos(Model model) {
        List<Medico> medicos = medicoRepository.readAll();
        model.addAttribute("medicos", medicos);
        return "medicos/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("medico", new Medico());
        return "medicos/add";
    }

    @PostMapping("/add")
    public String addMedico(@ModelAttribute Medico medico) {
        medicoRepository.create(medico);
        return "redirect:/medicos";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Medico medico = medicoRepository.read(id);
        model.addAttribute("medico", medico);
        return "medicos/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateMedico(@PathVariable int id, @ModelAttribute Medico medico) {
        medicoRepository.update(medico);
        return "redirect:/medicos";
    }

    @GetMapping("/delete/{id}")
    public String deleteMedico(@PathVariable int id) {
        medicoRepository.delete(id);
        return "redirect:/medicos";
    }
}