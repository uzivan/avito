package com.try_security.controllers;

import com.try_security.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping("/boughtPage")
    public String boughtPage(Model model){
        model.addAttribute("orders", cartService.getCartOrders());
        cartService.updateBelonging();
        return "boughtPage";
    }
    @GetMapping("/set")
    public String new_order(){
        return "addOrder";
    }
    @GetMapping("/deleteFromCart")
    public String deleteFromCart(@RequestParam("delid") int id){
        System.out.println(id);
        cartService.deleteOrder(id);
        return "redirect: cart";
    }
    @GetMapping("/cart")
    public String cart(Model model){
        System.out.println(cartService.getCartOrders());
        model.addAttribute("orders", cartService.getCartOrders());
        return "cart";
    }
    @RequestMapping("/addOrder")
    public String addOrder(HttpServletRequest request){
        cartService.setOrder(Integer.parseInt(request.getParameter("id")));
        return "redirect: cart";
    }
}
