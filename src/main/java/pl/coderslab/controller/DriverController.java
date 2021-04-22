package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Driver;
import pl.coderslab.service.DriverService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("user/data/driver")
public class DriverController{

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/all")
    public String showAllDrivers(Model model) {
        List<Driver> drivers = driverService.showAll();
        model.addAttribute("drivers", drivers);
        return "driverAll";
    }

    @GetMapping("/add")
    String showAddDriverForm(Model model) {
        model.addAttribute("driver", new Driver());
        return "driverFormAdd";
    }

    @PostMapping("/add")
    public String addDriver(@Valid Driver driver, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "driverFormAdd";
        }
        driverService.add(driver);
        return "redirect: all";
    }

    @GetMapping("/edit/{id}")
    public String editDriver(@PathVariable Long id, Model model) {
        Driver editDriver = driverService.showById(id);
        model.addAttribute("editDriver", editDriver);
        return "driverEdit";
    }

    @PostMapping("/edit")
    public String editDriver(@ModelAttribute("editDriver")
                            @Valid Driver editDriver, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "driverEdit";
        }
        driverService.add(editDriver);
        return "redirect: all";
    }

    @GetMapping("/delete/{id}")
    public String deleteDriver(@PathVariable Long id) {
        driverService.delete(id);
        return "redirect: /user/data/driver/all";
    }

}
