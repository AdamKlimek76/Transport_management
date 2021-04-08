package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.LoadingPlace;
import pl.coderslab.service.LoadingPlaceService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("user/data/loadingPlace")
public class LoadingPlaceController {

    private final LoadingPlaceService loadingPlaceService;

    public LoadingPlaceController(LoadingPlaceService loadingPlaceService) {
        this.loadingPlaceService = loadingPlaceService;
    }

    @GetMapping("/all")
    public String showAllLoadingPlaces(Model model) {
        List<LoadingPlace> loadingPlaces = loadingPlaceService.showAll();
        model.addAttribute("loadingPlaces", loadingPlaces);
        return "loadingPlaceAll";
    }

    @GetMapping("/add")
    String showAddLoadingPlaceForm(Model model) {
        model.addAttribute("loadingPlace", new LoadingPlace());
        return "loadingPlaceFormAdd";
    }

    @PostMapping("/add")
    public String addLoadingPlace(@Valid LoadingPlace loadingPlace, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "loadingPlaceFormAdd";
        }
        loadingPlaceService.add(loadingPlace);
        return "redirect: all";
    }

    @GetMapping("/edit/{id}")
    public String editLoadingPlace(@PathVariable Long id, Model model) {
        LoadingPlace editLoadingPlace = loadingPlaceService.showById(id).orElseThrow();
        model.addAttribute("editLoadingPlace", editLoadingPlace);
        return "loadingPlaceEdit";
    }

    @PostMapping("/edit")
    public String editLoadingPlace(@ModelAttribute("editLoadingPlace")
                             @Valid LoadingPlace editLoadingPlace, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "loadingPlaceEdit";
        }
        loadingPlaceService.add(editLoadingPlace);
        return "redirect: all";
    }

    @GetMapping("/delete/{id}")
    public String deleteLoadingPlace(@PathVariable Long id) {
        loadingPlaceService.delete(id);
        return "redirect: /user/data/loadingPlace/all";
    }
}
