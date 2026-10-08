package edu.wctc.wholesale.service;

import edu.wctc.wholesale.dto.OrderDto;
import edu.wctc.wholesale.entity.WholesaleOrder;
import edu.wctc.wholesale.repository.WholesaleOrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OrderService {

    private final WholesaleOrderRepository wholesaleOrderRepository;

    public OrderService(WholesaleOrderRepository wholesaleOrderRepository) {
        this.wholesaleOrderRepository = wholesaleOrderRepository;
    }

    public List<WholesaleOrder> getAllOrders() {
        return wholesaleOrderRepository.findAll();
    }

    public List<OrderDto> getAllOrderDtos() {
        return wholesaleOrderRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    private OrderDto toDto(WholesaleOrder order) {
        return new OrderDto(
                order.getCustomer() != null ? order.getCustomer().getName() : null,
                formatDate(order.getPurchaseDate()),
                order.getPurchaseOrderNumber(),
                order.getProduct() != null ? order.getProduct().getName() : null,
                order.getTerms(),
                formatDate(order.getShippedDate()),
                order.getProduct() != null ? order.getProduct().getCost() : null
        );
    }

    private String formatDate(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
