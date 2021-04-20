package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.OrderDtoNew;
import pl.coderslab.dto.OrderDtoToBook;
import pl.coderslab.dtoread.OrderDtoRead;
import pl.coderslab.dtoread.OrderDtoReadNew;
import pl.coderslab.model.*;
import pl.coderslab.service.*;

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
    private final DriverService driverService;
    private final SemitrailerService semitrailerService;
    private final TruckService truckService;


    public OrderController(OrderService orderService, LoadingPlaceService loadingPlaceService, UnloadingPlaceService unloadingPlaceService, CargoService cargoService, DriverService driverService, SemitrailerService semitrailerService, TruckService truckService) {
        this.orderService = orderService;
        this.loadingPlaceService = loadingPlaceService;
        this.unloadingPlaceService = unloadingPlaceService;
        this.cargoService = cargoService;
        this.driverService = driverService;
        this.semitrailerService = semitrailerService;
        this.truckService = truckService;
    }

    @GetMapping("/new")
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
        return "redirect: new";
    }

    @GetMapping("/edit/{id}")
    public String editNewOrder(@PathVariable Long id, Model model) {
        Order editNewOrder = orderService.showById(id);
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
        return "redirect: new";
    }

    @GetMapping("/delete/{id}")
    public String deleteNewOrder(@PathVariable Long id) {
        orderService.delete(id);
        return "redirect: /user/order/newOrder/new";
    }

    @GetMapping("/detail/{id}")
    public String showOrderDetails(@PathVariable Long id, Model model) {
        OrderDtoReadNew order = orderService.showNewOrderById(id).orElseThrow(EntityExistsException::new);
        model.addAttribute("orderDetails", order);
        return "newOrderDetails";
    }

    @GetMapping("/book/{id}")
    public String showOrderBookingForm(@PathVariable Long id, Model model) {
        OrderDtoToBook orderToBook = orderService.showOrderToBookById(id);
        model.addAttribute("orderToBook", orderToBook);
        return "bookOrderFormAdd";
    }

    @PostMapping("/book")
    public String editNewOrder(@ModelAttribute("orderToBook")
                               @Valid OrderDtoToBook orderToBook,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "bookOrderFormAdd";
        }
        orderService.bookNewOrder(orderToBook);
        return "redirect: booked";
    }

    @GetMapping("/booked")
    public String showAllBookedOrders(Model model) {
        List<OrderDtoRead> bookedOrders = orderService.showAllBookedOrders();
        model.addAttribute("bookedOrders", bookedOrders);
        return "bookOrderAll";
    }

    @GetMapping("/deleteBooked/{id}")
    public String deleteBookedOrder(@PathVariable Long id) {
        orderService.delete(id);
        return "redirect: /user/order/newOrder/booked";
    }

    @GetMapping("/editBooked/{id}")
    public String editBookedOrder(@PathVariable Long id, Model model) {
        Order editBookedOrder = orderService.showById(id);
        model.addAttribute("editBookedOrder", editBookedOrder);
        return "bookOrderEdit";
    }

    @PostMapping("/editBooked")
    public String editBookedOrder(@ModelAttribute("editBookedOrder")
                                  @Valid OrderDtoRead orderToBook,
                                  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "bookOrderEdit";
        }
        orderService.changeBookedOrder(orderToBook);
        return "redirect: booked";
    }

    @GetMapping("/done")
    public String showAllDoneOrders(Model model) {
        List<OrderDtoRead> doneOrders = orderService.showAllDoneOrders();
        model.addAttribute("doneOrders", doneOrders);
        return "doneOrderAll";
    }

    @PostMapping("/done/sorted")
    public String showDoneOrdersSorted(@RequestParam String sortedDoneOrders,
                                       @RequestParam String sortingOptions,
                                       Model model) {
        List<OrderDtoRead>sortedOrders=orderService.sortDoneOrders(sortedDoneOrders, sortingOptions);
        model.addAttribute("doneOrders", sortedOrders);
        return "doneOrderAll";
    }

    @PostMapping("/done/found")
    public String findDoneOrdersByColumn(@RequestParam String findDoneOrders,
                                       @RequestParam String searchedText,
                                         Model model) {
        List<OrderDtoRead>foundOrders=orderService.searchDoneOrders(findDoneOrders, searchedText);
        model.addAttribute("doneOrders", foundOrders);
        return "doneOrderAll";
    }

    @GetMapping("/all")
    public String showAllOrders(Model model) {
        List<OrderDtoRead> allOrders = orderService.showAllOrders();
        model.addAttribute("allOrders", allOrders);
        return "orderAll";
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

    @ModelAttribute("drivers")
    public List<Driver> drivers() {
        return driverService.showAll();
    }

    @ModelAttribute("semitrailers")
    public List<Semitrailer> semitrailers() {
        return semitrailerService.showAll();
    }

    @ModelAttribute("trucks")
    public List<Truck> trucks() {
        return truckService.showAll();
    }
}

