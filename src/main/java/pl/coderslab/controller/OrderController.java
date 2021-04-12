package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.OrderDtoNew;
import pl.coderslab.dtoread.OrderDtoReadNew;
import pl.coderslab.model.Cargo;
import pl.coderslab.model.LoadingPlace;
import pl.coderslab.model.Order;
import pl.coderslab.model.UnloadingPlace;
import pl.coderslab.service.CargoService;
import pl.coderslab.service.LoadingPlaceService;
import pl.coderslab.service.OrderService;
import pl.coderslab.service.UnloadingPlaceService;

import javax.persistence.EntityExistsException;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user/order/newOrder")
public class OrderController {

    private final OrderService orderService;
    private final LoadingPlaceService loadingPlaceService;
    private final UnloadingPlaceService unloadingPlaceService;
    private final CargoService cargoService;


    public OrderController(OrderService orderService, LoadingPlaceService loadingPlaceService, UnloadingPlaceService unloadingPlaceService, CargoService cargoService) {
        this.orderService = orderService;
        this.loadingPlaceService = loadingPlaceService;
        this.unloadingPlaceService = unloadingPlaceService;
        this.cargoService = cargoService;
    }

    @GetMapping("/all")
    public String showAllNewOrders(Model model) {
        List<OrderDtoReadNew> newOrders = orderService.showAllNewOrders();
        model.addAttribute("newOrders", newOrders);
        return "newOrderAll";
    }

    @GetMapping("/add")
    String showAddNewOrderForm(Model model) {
        model.addAttribute("newOrder", new OrderDtoNew());
        return "newOrderFormAdd";
    }

    @PostMapping("/add")
    public String addNewOrder(@Valid OrderDtoNew newOrder, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "newOrderFormAdd";
        }
        orderService.addNewOrder(newOrder);
        return "redirect: all";
    }

    @GetMapping("/edit/{id}")
    public String editNewOrder(@PathVariable Long id, Model model) {
        Order editNewOrder = orderService.showById(id).orElseThrow(EntityExistsException::new);
        model.addAttribute("editNewOrder", editNewOrder);
        return "newOrderEdit";
    }

    @PostMapping("/edit")
    public String editNewOrder(@ModelAttribute("editNewOrder")
                               @Valid OrderDtoReadNew editNewOrder, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "newOrderEdit";
        }
        orderService.updateNewOrder(editNewOrder);
        return "redirect: all";
    }

    @GetMapping("/delete/{id}")
    public String deleteNewOrder(@PathVariable Long id) {
        orderService.delete(id);
        return "redirect: /user/order/newOrder/all";
    }

    @GetMapping("/detail/{id}")
    public String showOrderDetails(@PathVariable Long id, Model model){
        OrderDtoReadNew order = orderService.showNewOrderById(id).orElseThrow(EntityExistsException::new);
        model.addAttribute("orderDetails", order);
        return "newOrderDetails";
    }

    @GetMapping("/book/{id}")
    @ResponseBody
    public String showOrderBookingForm(@PathVariable Long id, Model model){
        return "Awizacja";
    }

    @ModelAttribute("loadingPlaces")
    public List<LoadingPlace> loadingPlaces() {
        return loadingPlaceService.showAll();
    }

    @ModelAttribute("unloadingPlaces")
    public List<UnloadingPlace> unloadingPlaces() {
        return unloadingPlaceService.showAll();
    }

    @ModelAttribute("cargos")
    public List<Cargo> cargos() {
        return cargoService.showAll();
    }
}

