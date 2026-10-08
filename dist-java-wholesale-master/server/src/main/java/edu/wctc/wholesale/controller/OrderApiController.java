package edu.wctc.wholesale.controller;

import edu.wctc.wholesale.dto.OrderDto;
import edu.wctc.wholesale.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderApiController {

    private final OrderService orderService;

    public OrderApiController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = {"/orders", "/orders/"})
    public List<OrderDto> getOrders() {
        return orderService.getAllOrderDtos();
    }
}
