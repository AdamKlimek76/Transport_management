package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.UnloadingPlace;
import pl.coderslab.service.UnloadingPlaceService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("user/data/unloadingPlace")
public class UnloadingPlaceController {

    private final UnloadingPlaceService unloadingPlaceService;

    public UnloadingPlaceController(UnloadingPlaceService unloadingPlaceService) {
        this.unloadingPlaceService = unloadingPlaceService;
    }

    @GetMapping("/all")
    public String showAllUnloadingPlaces(Model model) {
        List<UnloadingPlace> unloadingPlaces = unloadingPlaceService.showAll();
        model.addAttribute("unloadingPlaces", unloadingPlaces);
        return "unloadingPlaceAll";
    }

    @GetMapping("/add")
    String showAddLoadingPlaceForm(Model model) {
        model.addAttribute("unloadingPlace", new UnloadingPlace());
        return "unloadingPlaceFormAdd";
    }

    @PostMapping("/add")
    public String addUnloadingPlace(@Valid UnloadingPlace unloadingPlace, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "unloadingPlaceFormAdd";
        }
        unloadingPlaceService.add(unloadingPlace);
        return "redirect: all";
    }

    @GetMapping("/edit/{id}")
    public String editUnloadingPlace(@PathVariable Long id, Model model) {
        UnloadingPlace editUnloadingPlace = unloadingPlaceService.showById(id);
        model.addAttribute("editUnloadingPlace", editUnloadingPlace);
        return "unloadingPlaceEdit";
    }

    @PostMapping("/edit")
    public String editUnloadingPlace(@ModelAttribute("editUnloadingPlace")
                                   @Valid UnloadingPlace editUnloadingPlace, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "unloadingPlaceEdit";
        }
        unloadingPlaceService.add(editUnloadingPlace);
        return "redirect: all";
    }

    @GetMapping("/delete/{id}")
    public String deleteUnloadingPlace(@PathVariable Long id) {
        unloadingPlaceService.delete(id);
        return "redirect: /user/data/unloadingPlace/all";
    }

}
