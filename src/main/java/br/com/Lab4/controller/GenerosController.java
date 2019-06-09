package br.com.Lab4.controller;

import br.com.Lab4.domain.Generos;
import br.com.Lab4.service.GenerosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("categorias/{categoriasId}/generos")
public class GenerosController {

    @Autowired
    private GenerosService generosService;

    @GetMapping("/listar")
    public ModelAndView listar(@PathVariable("categoriasId") long categoriasId, ModelMap model) {
        model.addAttribute("generos", generosService.recuperarPorCategorias(categoriasId));
        model.addAttribute("categoriasId", categoriasId);
        return new ModelAndView("/generos/list", model);
    }

    @GetMapping("/cadastro")
    public String preSalvar(@ModelAttribute("generos") Generos generos, @PathVariable("categoriasId") long categoriasId) {
        return "/generos/add";
    }

    @PostMapping("/salvar")
    public String salvar(@PathVariable("categoriasId") long categoriasId, @Valid @ModelAttribute("generos")
            Generos generos, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/generos/add";
        }

        generosService.salvar(generos, categoriasId);
        attr.addFlashAttribute("mensagem", "Gênero salvo com sucesso!");
        return "redirect:/categorias/" + categoriasId + "/generos/listar";
    }

    @GetMapping("/{generosId}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("categoriasId") long categoriasId, @PathVariable("generosId")
            long generosId, ModelMap model) {
        Generos generos = generosService.recuperarPorCategoriasIdEGenerosId(categoriasId, generosId);
        model.addAttribute("generos", generos);
        model.addAttribute("categoriasId", categoriasId);
        return new ModelAndView("/generos/add", model);
    }

    @PutMapping("/salvar")
    public ModelAndView atualizar(@PathVariable("categoriasId") long categoriasId, @Valid @ModelAttribute("generos")
            Generos generos, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return new ModelAndView("/generos/add");
        }

        generosService.atualizar(generos, categoriasId);
        attr.addFlashAttribute("mensagem", "Gênero atualizado com sucesso!");
        return new ModelAndView("redirect:/categorias/" + categoriasId + "/generos/listar");
    }

    @GetMapping("/{generosId}/remover")
    public String remover(@PathVariable("categoriasId") long categoriasId, @PathVariable("generosId")
            long generosId, RedirectAttributes attr) {
        generosService.excluir(categoriasId, generosId);
        attr.addFlashAttribute("mensagem", "Gênero excluído com sucesso!");
        return "redirect:/categorias/" + categoriasId + "/generos/listar";
    }
}