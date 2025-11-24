package br.edu.com.fateczl.av3LabBD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.com.fateczl.av3LabBD.service.HistoricoService;

@Controller
@RequestMapping("/historico")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping
    public String listarHistorico(Model model) {
        model.addAttribute("historicos", historicoService.listarHistorico());
        return "crudHistorico";
    }
}
