package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Cargo;
import pl.coderslab.service.CargoService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("user/data/cargo")
public class CargoController {

    private final CargoService cargoService;


    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping("/all")
    public String showAllCargos(Model model) {
        List<Cargo> cargos = cargoService.showAll();
        model.addAttribute("cargos", cargos);
        return "cargoAll";
    }

    @GetMapping("/add")
    String showAddCargoForm(Model model) {
        model.addAttribute("cargo", new Cargo());
        return "cargoFormAdd";
    }

    @PostMapping("/add")
    public String addCargo(@Valid Cargo cargo, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "cargoFormAdd";
        }
        cargoService.add(cargo);
        return "redirect: all";
    }

    @GetMapping("/edit/{id}")
    public String editCargo(@PathVariable Long id, Model model) {
        Cargo editCargo = cargoService.showById(id).orElseThrow();
        model.addAttribute("editCargo", editCargo);
        return "cargoEdit";
    }

    @PostMapping("/edit")
    public String editCargo(@ModelAttribute("editCargo")
                             @Valid Cargo editCargo, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "cargoEdit";
        }
        cargoService.add(editCargo);
        return "redirect: all";
    }

    @GetMapping("/delete/{id}")
    public String deleteCargo(@PathVariable Long id) {
        cargoService.delete(id);
        return "redirect: /user/data/cargo/all";
    }

}
