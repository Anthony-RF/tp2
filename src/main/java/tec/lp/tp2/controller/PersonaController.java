package tec.lp.tp2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tec.lp.tp2.Repository.PersonaRepository;
import tec.lp.tp2.model.Persona;

import java.util.List;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @GetMapping
    public String listPersonas(Model model) {
        List<Persona> personas = personaRepository.readAll();
        model.addAttribute("personas", personas);
        return "personas/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("persona", new Persona());
        return "personas/add";
    }

    @PostMapping("/add")
    public String addPersona(@ModelAttribute Persona persona) {
        personaRepository.create(persona);
        return "redirect:/personas";
    }

    @GetMapping("/edit/{cedula}")
    public String showEditForm(@PathVariable int cedula, Model model) {
        Persona persona = personaRepository.read(cedula);
        model.addAttribute("persona", persona);
        return "personas/edit";
    }

    @PostMapping("/edit/{cedula}")
    public String updatePersona(@PathVariable int cedula, @ModelAttribute Persona persona) {
        personaRepository.update(persona);
        return "redirect:/personas";
    }

    @GetMapping("/delete/{cedula}")
    public String deletePersona(@PathVariable int cedula) {
        personaRepository.delete(cedula);
        return "redirect:/personas";
    }
}
