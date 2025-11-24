package br.edu.com.fateczl.av3LabBD.controller;

import br.edu.com.fateczl.av3LabBD.dto.ClienteDTO;
import br.edu.com.fateczl.av3LabBD.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listarClientes(Model model) {
        List<ClienteDTO> clientes = clienteService.listarTodos();
        model.addAttribute("novoCliente", new ClienteDTO());
        model.addAttribute("clientes", clientes);
        return "crudCliente"; // nome do template HTML
    }

    @PostMapping("/add")
    public String adicionar(@ModelAttribute("novoCliente") ClienteDTO dto) {
        clienteService.salvar(dto);
        return "redirect:/clientes";
    }

    @PostMapping("/update")
    public String atualizar(@ModelAttribute ClienteDTO dto) {
        clienteService.salvar(dto);
        return "redirect:/clientes";
    }

    @PostMapping("/delete")
    public String deletar(@RequestParam("cpf") String cpf) {
        clienteService.deletar(cpf);
        return "redirect:/clientes";
    }
}
