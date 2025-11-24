package br.edu.com.fateczl.av3LabBD.controller;

import br.edu.com.fateczl.av3LabBD.dto.CategoriaDTO;
import br.edu.com.fateczl.av3LabBD.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Página principal do CRUD de categorias
    @GetMapping
    public String listarCategorias(Model model) {
        List<CategoriaDTO> categorias = categoriaService.listarTodas();
        model.addAttribute("novaCategoria", new CategoriaDTO());
        model.addAttribute("categorias", categorias);
        return "crudCategoria"; // nome do template HTML
    }

    // Inserir nova categoria
    @PostMapping("/add")
    public String adicionarCategoria(@ModelAttribute("novaCategoria") CategoriaDTO dto) {
        categoriaService.salvar(dto);
        return "redirect:/categoria";
    }

    // Atualizar categoria
    @PostMapping("/update")
    public String atualizarCategoria(@ModelAttribute CategoriaDTO dto) {
        categoriaService.salvar(dto); // save já faz update se o ID existir
        return "redirect:/categoria";
    }

    // Deletar categoria
    @PostMapping("/delete")
    public String deletarCategoria(@RequestParam("id") Long id) {
        categoriaService.deletar(id);
        return "redirect:/categoria";
    }
}
