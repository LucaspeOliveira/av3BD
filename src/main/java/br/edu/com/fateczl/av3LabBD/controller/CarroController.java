package br.edu.com.fateczl.av3LabBD.controller;

import br.edu.com.fateczl.av3LabBD.dto.CarroDTO;
import br.edu.com.fateczl.av3LabBD.dto.CategoriaDTO;
import br.edu.com.fateczl.av3LabBD.service.CarroService;
import br.edu.com.fateczl.av3LabBD.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Página principal do CRUD
    @GetMapping
    public String listarCarros(Model model) {
        List<CarroDTO> carros = carroService.listarTodos();
        List<CategoriaDTO> categorias = categoriaRepository.findAll()
                .stream()
                .map(cat -> new CategoriaDTO(cat.getId(), cat.getNome(), cat.getValorDiaria()))
                .collect(Collectors.toList());

        model.addAttribute("novoCarro", new CarroDTO());
        model.addAttribute("carros", carros);
        model.addAttribute("categorias", categorias);

        return "crudCarro"; // nome do template
    }

    // Inserir novo carro
    @PostMapping("/add")
    public String adicionarCarro(@ModelAttribute("novoCarro") CarroDTO dto) {
        carroService.salvar(dto);
        return "redirect:/carros";
    }

    // Listar todos
    @GetMapping("/all")
    public String listarTodos(Model model) {
        return listarCarros(model);
    }

    // Listar disponíveis (via UDF)
    @GetMapping("/disponiveis")
    public String listarDisponiveis(Model model) {
        List<CarroDTO> carros = carroService.listarDisponiveis();
        List<CategoriaDTO> categorias = categoriaRepository.findAll()
                .stream()
                .map(cat -> new CategoriaDTO(cat.getId(), cat.getNome(), cat.getValorDiaria()))
                .collect(Collectors.toList());

        model.addAttribute("novoCarro", new CarroDTO());
        model.addAttribute("carros", carros);
        model.addAttribute("categorias", categorias);

        return "crudCarro";
    }

    // Atualizar carro
    @PostMapping("/update")
    public String atualizarCarro(@ModelAttribute CarroDTO dto) {
        carroService.salvar(dto); // save já faz update se a placa existir
        return "redirect:/carros";
    }

    // Deletar carro
    @PostMapping("/delete")
    public String deletarCarro(@RequestParam("placa") String placa) {
        carroService.deletar(placa);
        return "redirect:/carros";
    }
}
