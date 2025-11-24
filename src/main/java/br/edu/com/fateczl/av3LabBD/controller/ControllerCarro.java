package br.edu.com.fateczl.av3LabBD.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.edu.com.fateczl.av3LabBD.dto.DTOCarro;
import br.edu.com.fateczl.av3LabBD.model.Categoria;
import br.edu.com.fateczl.av3LabBD.service.ServiceCarro;
import br.edu.com.fateczl.av3LabBD.service.ServiceCategoria;

@Controller
@RequestMapping("/carros")
public class ControllerCarro {

    private final ServiceCarro serviceCarro;
    private final ServiceCategoria serviceCategoria;

    public ControllerCarro(ServiceCarro serviceCarro, ServiceCategoria serviceCategoria) {
        this.serviceCarro = serviceCarro;
        this.serviceCategoria = serviceCategoria;
    }

    // Listar todos os carros
    @GetMapping
    public String listar(Model model) {
        List<DTOCarro> carros = serviceCarro.listarTodosCarros();
        List<Categoria> categorias = serviceCategoria.listarTodas();

        model.addAttribute("carros", carros);
        model.addAttribute("novoCarro", new DTOCarro());
        model.addAttribute("categorias", categorias);

        return "crudCarro";
    }

    // Adicionar novo carro
    @PostMapping("/add")
    public String adicionar(@ModelAttribute DTOCarro dtoCarro) {
        serviceCarro.salvar(dtoCarro);
        return "redirect:/carros";
    }

    // Remover carro pela placa
    @PostMapping("/delete")
    public String remover(@RequestParam String placa) {
        serviceCarro.remover(placa);
        return "redirect:/carros";
    }

    // Buscar carro por placa (exemplo de endpoint extra)
    @GetMapping("/{placa}")
    public String buscarPorPlaca(@PathVariable String placa, Model model) {
        DTOCarro carro = serviceCarro.buscarPorPlaca(placa);
        model.addAttribute("carro", carro);
        return "detalheCarro"; // você pode criar um template para detalhes
    }
    
    @GetMapping("/disponiveis")
    public String listarDisponiveis(Model model) {
        model.addAttribute("carros", serviceCarro.listarCarrosDisponiveis());
        model.addAttribute("novoCarro", new DTOCarro());
        model.addAttribute("categorias", serviceCategoria.listarTodas());
        return "crudCarro";
    }
}
