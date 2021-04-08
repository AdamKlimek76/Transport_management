package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Truck;
import pl.coderslab.service.TruckService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("user/data/truck")
public class TruckController {

    private final TruckService truckService;

    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @GetMapping("/all")
    public String showAllTrucks(Model model) {
        List<Truck> trucks = truckService.showAll();
        model.addAttribute("trucks", trucks);
        return "truckAll";
    }

    @GetMapping("/add")
    String showAddTruckForm(Model model) {
        model.addAttribute("truck", new Truck());
        return "truckFormAdd";
    }

    @PostMapping("/add")
    public String addTruck(@Valid Truck truck, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "truckFormAdd";
        }
        truckService.add(truck);
        return "redirect: all";
    }

    @GetMapping("/edit/{id}")
    public String editTruck(@PathVariable Long id, Model model) {
        Truck editTruck = truckService.showById(id).orElseThrow();
        model.addAttribute("editTruck", editTruck);
        return "truckEdit";
    }

    @PostMapping("/edit")
    public String editTruck(@ModelAttribute("editTruck")
                           @Valid Truck editTruck, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "truckEdit";
        }
        truckService.add(editTruck);
        return "redirect: all";
    }

    @GetMapping("/delete/{id}")
    public String deleteTruck(@PathVariable Long id) {
        truckService.delete(id);
        return "redirect: /user/data/truck/all";
    }

}
