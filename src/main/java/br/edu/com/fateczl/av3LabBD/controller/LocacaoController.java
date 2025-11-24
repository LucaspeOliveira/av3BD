package br.edu.com.fateczl.av3LabBD.controller;

import br.edu.com.fateczl.av3LabBD.dto.LocacaoDTO;
import br.edu.com.fateczl.av3LabBD.service.LocacaoService;
import br.edu.com.fateczl.av3LabBD.service.ClienteService;
import br.edu.com.fateczl.av3LabBD.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/locacoes")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CarroService carroService;

    @GetMapping
    public String listarLocacoes(Model model) {
        model.addAttribute("novaLocacao", new LocacaoDTO());
        model.addAttribute("locacoes", locacaoService.listarTodos());
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("carros", carroService.listarTodos());
        return "crudLocacao"; // nome do template
    }

    @PostMapping("/add")
    public String adicionar(@ModelAttribute("novaLocacao") LocacaoDTO dto) {
        locacaoService.salvar(dto);
        return "redirect:/locacoes";
    }

    @PostMapping("/update")
    public String atualizar(@ModelAttribute LocacaoDTO dto) {
        locacaoService.salvar(dto);
        return "redirect:/locacoes";
    }

    @PostMapping("/delete")
    public String deletar(@RequestParam("id") Long id) {
        locacaoService.deletar(id);
        return "redirect:/locacoes";
    }
}
