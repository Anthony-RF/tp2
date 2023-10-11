package tec.lp.tp2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tec.lp.tp2.Repository.CitaRepository;
import tec.lp.tp2.model.Cita;

import java.util.List;

@Controller
@RequestMapping("/citas")
public class CitaController {

    private final CitaRepository citaRepository;

    @Autowired
    public CitaController(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @GetMapping
    public String listCitas(Model model) {
        List<Cita> citas = citaRepository.readAll();
        model.addAttribute("citas", citas);
        return "citas/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("cita", new Cita());
        return "citas/add";
    }

    @PostMapping("/add")
    public String addCita(@ModelAttribute Cita cita) {
        citaRepository.create(cita);
        return "redirect:/citas";
    }

    @GetMapping("/edit/{fecha}")
    public String showEditForm(@PathVariable String fecha, Model model) {
        Cita cita = citaRepository.read(fecha);
        model.addAttribute("cita", cita);
        return "citas/edit";
    }

    @PostMapping("/edit/{fecha}")
    public String updateCita(@PathVariable String fecha, @ModelAttribute Cita cita) {
        citaRepository.update(cita);
        return "redirect:/citas";
    }

    @GetMapping("/delete/{fecha}")
    public String deleteCita(@PathVariable String fecha) {
        citaRepository.delete(fecha);
        return "redirect:/citas";
    }
}
