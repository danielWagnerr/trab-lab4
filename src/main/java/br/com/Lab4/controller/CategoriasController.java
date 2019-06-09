package br.com.Lab4.controller;

import br.com.Lab4.domain.Categorias;
import br.com.Lab4.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("categorias")
public class CategoriasController {

    @Autowired
    private CategoriasService categoriasService;

    @GetMapping("/listar")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("categorias", categoriasService.recuperar());
        return new ModelAndView("/categorias/list", model);
    }

    @GetMapping("/cadastro")
    public String preSalvar(@ModelAttribute("categorias") Categorias categorias) {
        return "/categorias/add";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("categorias") Categorias categorias, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/categorias/add";
        }

        categoriasService.salvar(categorias);
        attr.addFlashAttribute("mensagem", "Categoria criada com sucesso!");
        return "redirect:/categorias/listar";
    }

    @GetMapping("/{id}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("id") long id, ModelMap model) {
        Categorias categorias = categoriasService.recuperarPorId(id);
        model.addAttribute("categorias", categorias);
        return new ModelAndView("/categorias/add", model);
    }

    @PutMapping("/salvar")
    public ModelAndView atualizar(@Valid @ModelAttribute("categorias") Categorias categorias, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return new ModelAndView("/categorias/add");
        }

        categoriasService.atualizar(categorias);
        attr.addFlashAttribute("mensagem", "Categoria atualizada com sucesso!");
        return new ModelAndView("redirect:/categorias/listar");
    }

    @GetMapping("/{id}/remover")
    public String remover(@PathVariable("id") long id, RedirectAttributes attr) {
        categoriasService.excluir(id);
        attr.addFlashAttribute("mensagem", "Categoria excluída com sucesso!");
        return "redirect:/categorias/listar";
    }

}