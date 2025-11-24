package br.edu.com.fateczl.av3LabBD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.com.fateczl.av3LabBD.dto.ReparoDTO;
import br.edu.com.fateczl.av3LabBD.service.CarroService;
import br.edu.com.fateczl.av3LabBD.service.ReparoService;


@Controller
@RequestMapping("/reparos")
public class ReparoController {

    @Autowired
    private ReparoService reparoService;

    @Autowired
    private CarroService carroService;

    @GetMapping
    public String listarReparos(Model model) {
        model.addAttribute("novoReparo", new ReparoDTO());
        model.addAttribute("reparos", reparoService.listarTodos());
        model.addAttribute("carros", carroService.listarTodos());
        return "crudReparo";
    }

    @PostMapping("/add")
    public String adicionar(@ModelAttribute("novoReparo") ReparoDTO dto) {
        reparoService.salvar(dto);
        return "redirect:/reparos";
    }

    @PostMapping("/update")
    public String atualizar(@ModelAttribute ReparoDTO dto) {
        reparoService.salvar(dto);
        return "redirect:/reparos";
    }

    @PostMapping("/delete")
    public String deletar(@RequestParam("id") Long id) {
        reparoService.deletar(id);
        return "redirect:/reparos";
    }
}
