package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Semitrailer;
import pl.coderslab.service.SemitrailerService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("user/data/semitrailer")
public class SemitrailerController {

    private final SemitrailerService semitrailerService;

    public SemitrailerController(SemitrailerService semitrailerService) {
        this.semitrailerService = semitrailerService;
    }

    @GetMapping("/all")
    public String showAllSemitrailers(Model model) {
        List<Semitrailer> semitrailers = semitrailerService.showAll();
        model.addAttribute("semitrailers", semitrailers);
        return "semitrailerAll";
    }

    @GetMapping("/add")
    String showAddSemitrailerForm(Model model) {
        model.addAttribute("semitrailer", new Semitrailer());
        return "semitrailerFormAdd";
    }

    @PostMapping("/add")
    public String addSemitrailer(@Valid Semitrailer semitrailer, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "semitrailerFormAdd";
        }
        semitrailerService.add(semitrailer);
        return "redirect: all";
    }

    @GetMapping("/edit/{id}")
    public String editSemitrailer(@PathVariable Long id, Model model) {
        Semitrailer editSemitrailer = semitrailerService.showById(id).orElseThrow();
        model.addAttribute("editSemitrailer", editSemitrailer);
        return "semitrailerEdit";
    }

    @PostMapping("/edit")
    public String editSemitrailer(@ModelAttribute("editSemitrailer")
                            @Valid Semitrailer editSemitrailer, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "semitrailerEdit";
        }
        semitrailerService.update(editSemitrailer);
        return "redirect: all";
    }

    @GetMapping("/delete/{id}")
    public String deleteSemitrailer(@PathVariable Long id) {
        semitrailerService.delete(id);
        return "redirect: /user/data/semitrailer/all";
    }

}
