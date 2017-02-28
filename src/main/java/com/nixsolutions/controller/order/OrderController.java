package com.nixsolutions.controller.order;

import com.nixsolutions.bean.Book;
import com.nixsolutions.bean.Order;
import com.nixsolutions.service.BookService;
import com.nixsolutions.service.OrderService;
import com.nixsolutions.service.OrderTypeService;
import com.nixsolutions.service.UserService;
import com.nixsolutions.util.OrderReturnDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Date;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderTypeService orderTypeService;

    private Book book;
    private List<Order> orders;

    @RequestMapping(value = "/add_order", method = RequestMethod.GET)
    public String addOrderForm(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("orderTypes", orderTypeService.getAllOrderTypes());
        return "addOrder";
    }
    @RequestMapping(value = "/add_order", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order") Order order, Model model) {
        book = bookService.getBook(order.getBook().getBookID());
        if (book.getBookInWarehouse() > 0) {
            order.setExpectedReturnDate(new Date(new OrderReturnDateUtil().setExpectedReturnDate(order.getOrderType().getOrderTypeID())));
            orderService.add(order);
            book.setBookInWarehouse(book.getBookInWarehouse() - 1);
            bookService.edit(book);
            return "redirect:/orders";
        } else {
            model.addAttribute("error", "Sorry, cannot create order. In warehouse no book.");
            return "redirect:/orders";
        }
    }

    @RequestMapping(value = "/close/{order_id}", method = RequestMethod.GET)
    public String closeOrder(@PathVariable("order_id") Long orderID) {
        Order order = orderService.getOrder(orderID);
        order.setActualReturnDate(new Date(System.currentTimeMillis()));
        orderService.edit(order);
        book = bookService.getBook(order.getBook().getBookID());
        book.setBookInWarehouse(book.getBookInWarehouse() + 1);
        bookService.edit(book);
        return "redirect:/orders";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String viewOrderForm(Model model) {
        orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            model.addAttribute("error", "Table orders is empty.");
            return "orders";
        } else {
            model.addAttribute("orders", orders);
            return "orders";
        }
    }


}
