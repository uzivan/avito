package com.try_security.controllers;
//import com.sun.org.apache.xpath.internal.operations.Or;
import com.try_security.dao.UserDAOImpl;
import com.try_security.entity.Order;
import com.try_security.entity.User;
import com.try_security.service.AddUserService;
import com.try_security.service.CartService;
import com.try_security.service.OrderService;
import com.try_security.service.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class OrderController {
//    @Autowired
//    private AddUserService addUserService;
    @Autowired
    private OrderService orderService;
//    @Autowired
//    private CartService cartService;
//    @Autowired
//    private SalesmanService salesmanService;

    @GetMapping("/")
    public String main_page() {
        return "main_page";
    }


//    @GetMapping("/hello")
//    public String hello_page() {
//        return "hello";
//    }
//
//    @GetMapping("/registration")
//    public String registration() {
////        User user = new User();
////        model.addAttribute("user", user);
//        return "registration";
//    }
//
//    @PostMapping("/save_user")
//    public String save(HttpServletRequest request) {
//        User user = new User();
//        user.setEnabled(Integer.parseInt(request.getParameterValues("enabled")[0]));
//        user.setPassword(request.getParameterValues("password")[0]);
//        user.setUsername(request.getParameterValues("username")[0]);
//        String[] roles = request.getParameterValues("role");
//        addUserService.addUser(user, roles);
//        return "redirect: /";
//    }

    @GetMapping("/show")
    public String showAll(HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("orders", orderService.showOnSaleOrder());
        return "show";
    }
    @GetMapping("/description/{id}")
    public String showDescription(@PathVariable("id") int id, Model model){
        model.addAttribute("order", orderService.getOrder(id));
        return "description";
    }
//    @GetMapping("/cart")
//    public String cart(Model model){
//        System.out.println(cartService.getCartOrders());
//        model.addAttribute("orders", cartService.getCartOrders());
//        return "cart";
//    }
//    @RequestMapping("/addOrder")
//    public String addOrder(HttpServletRequest request){
//        cartService.setOrder(Integer.parseInt(request.getParameter("id")));
//        return "redirect: /cart";
//    }
    @PostMapping("/set")
    public String setOrder(HttpServletRequest request){
        Order order = new Order(
                request.getParameter("name"),
                Integer.parseInt(request.getParameter("price")),
                request.getParameter("description"));
        orderService.setOrder(order, Integer.parseInt(request.getParameter("count")));
        return "redirect: set";
    }
//    @GetMapping("/set")
//    public String new_order(){
//        return "addOrder";
//    }
//    @GetMapping("/deleteFromCart")
//    public String deleteFromCart(@RequestParam("delid") int id){
//        System.out.println(id);
//        cartService.deleteOrder(id);
//        return "redirect: /cart";
//    }
//    @GetMapping("/salesmanPage")
//    public String salesmanPage(Model model){
//        model.addAttribute("ordersOnSale", salesmanService.ordersOnSale());
//        model.addAttribute("ordersInCart", salesmanService.ordersFromUsers("InCart"));
//        model.addAttribute("ordersBought", salesmanService.ordersFromUsers("Bought"));
//        return "salesmanPage";
//    }
//    @GetMapping("/deleteOrder")
//    public String salesmanPage(@RequestParam("delid") int id){
//        salesmanService.deleteOrder(id);
//        return "redirect: /salesmanPage";
//    }
//    @GetMapping("/boughtPage")
//    public String boughtPage(Model model){
//        model.addAttribute("orders", cartService.getCartOrders());
//        cartService.updateBelonging();
//        return "boughtPage";
//    }
}
