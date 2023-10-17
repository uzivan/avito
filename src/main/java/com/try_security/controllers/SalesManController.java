package com.try_security.controllers;

import com.try_security.service.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SalesManController {
    @Autowired
    private SalesmanService salesmanService;
    @GetMapping("/salesmanPage")
    public String salesmanPage(Model model){
        model.addAttribute("ordersOnSale", salesmanService.ordersOnSale());
        model.addAttribute("ordersInCart", salesmanService.ordersFromUsers("InCart"));
        model.addAttribute("ordersBought", salesmanService.ordersFromUsers("Bought"));
        return "salesmanPage";
    }
    @GetMapping("/deleteOrder")
    public String salesmanPage(@RequestParam("delid") int id){
        salesmanService.deleteOrder(id);
        return "redirect: salesmanPage";
    }
}
