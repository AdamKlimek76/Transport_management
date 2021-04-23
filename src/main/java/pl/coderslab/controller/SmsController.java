package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.OrderNewDto;
import pl.coderslab.dto.SmsDto;
import pl.coderslab.dtoread.OrderReadNewDto;
import pl.coderslab.dtoread.SmsReadDto;
import pl.coderslab.service.DriverService;
import pl.coderslab.service.OrderService;
import pl.coderslab.service.SmsService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user/reports/sms")
public class SmsController {

    private final SmsService smsService;
    private final static Logger log= LoggerFactory.getLogger(SmsController.class);

    public SmsController(SmsService smsService, OrderService orderService, DriverService driverService) {
        this.smsService = smsService;
    }

    @GetMapping("/all")
    public String showAllSms(Model model) {
        List<SmsReadDto> allSms = smsService.showAllSms();
        model.addAttribute("allSms", allSms);
        return "smsAll";
    }

    @GetMapping("/add/{orderId}")
    public String sendSmsForm(@PathVariable Long orderId, Model model) {
        SmsDto smsFull = smsService.showSmsSendFullForm(orderId);
        SmsDto smsAlias = smsService.showSmsSendAliasForm(orderId);
        model.addAttribute("smsFull", smsFull);
        model.addAttribute("smsAlias", smsAlias);

        return "smsFormSend";
    }

    @PostMapping("/add/full")
    public String sendSmsFull(@Valid SmsDto smsFull, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "smsFormSend";
        }
        smsService.addSms(smsFull);
        log.info(smsFull.getMessage());
        return "redirect: /user/reports/sms/all";
    }

    @PostMapping("/add/alias")
    public String addNewOrder(@Valid SmsDto smsAlias, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "smsFormSend";
        }
        smsService.addSms(smsAlias);
        log.info(smsAlias.getMessage());
        return "redirect: /user/reports/sms/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBookedOrder(@PathVariable Long id) {
        smsService.delete(id);
        return "redirect: /user/reports/sms/all";

    }
}