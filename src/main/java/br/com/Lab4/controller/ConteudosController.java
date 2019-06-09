package br.com.Lab4.controller;

import br.com.Lab4.domain.Conteudos;
import br.com.Lab4.service.ConteudosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("generos/{generosId}/conteudos")
public class ConteudosController {

    @Autowired
    private ConteudosService conteudosService;

    @GetMapping("/listar")
    public ModelAndView listar(@PathVariable("generosId") long generosId, ModelMap model) {
        model.addAttribute("conteudos", conteudosService.recuperarPorGeneros(generosId));
        model.addAttribute("generosId", generosId);
        return new ModelAndView("/conteudos/list", model);
    }

    @GetMapping("/cadastro")
    public String preSalvar(@ModelAttribute("conteudos") Conteudos conteudos, @PathVariable("generosId") long generosId) {
        return "/conteudos/add";
    }

    @PostMapping("/salvar")
    public String salvar(@PathVariable("generosId") long generosId, @Valid @ModelAttribute("conteudos")
            Conteudos conteudos, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/conteudos/add";
        }

        conteudosService.salvar(conteudos, generosId);
        attr.addFlashAttribute("mensagem", "Conteúdo salvo com sucesso!");
        return "redirect:/generos/" + generosId + "/conteudos/listar";
    }

    @GetMapping("/{conteudosId}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("generosId") long generosId, @PathVariable("conteudosId")
            long conteudosId, ModelMap model) {
        Conteudos conteudos = conteudosService.recuperarPorGenerosIdEConteudosId(generosId, conteudosId);
        model.addAttribute("conteudos", conteudos);
        model.addAttribute("generosId", generosId);
        return new ModelAndView("/conteudos/add", model);
    }

    @PutMapping("/salvar")
    public ModelAndView atualizar(@PathVariable("generosId") long generosId, @Valid @ModelAttribute("conteudos")
            Conteudos conteudos, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return new ModelAndView("/conteudos/add");
        }

        conteudosService.atualizar(conteudos, generosId);
        attr.addFlashAttribute("mensagem", "Conteúdo atualizado com sucesso!");
        return new ModelAndView("redirect:/generos/" + generosId + "/conteudos/listar");
    }

    @GetMapping("/{conteudosId}/remover")
    public String remover(@PathVariable("generosId") long generosId, @PathVariable("conteudosId")
            long conteudosId, RedirectAttributes attr) {
        conteudosService.excluir(generosId, conteudosId);
        attr.addFlashAttribute("mensagem", "Conteúdo excluído com sucesso!");
        return "redirect:/generos/" + generosId + "/conteudos/listar";
    }
}