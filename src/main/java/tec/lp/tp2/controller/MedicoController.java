package tec.lp.tp2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tec.lp.tp2.dao.MedicoDao;
import tec.lp.tp2.model.Medico;
import java.util.List;

@RestController
public class MedicoController {

    @Autowired
    private MedicoDao medicoDao;

    @RequestMapping(value = "Medicos")
    public List<Medico> readAllMedico()
    {
        return medicoDao.readAllMedico();

    }

}
