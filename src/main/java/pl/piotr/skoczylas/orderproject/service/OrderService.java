package pl.piotr.skoczylas.orderproject.service;

import pl.piotr.skoczylas.orderproject.dto.OrderDto;
import pl.piotr.skoczylas.orderproject.dto.OrderItemDto;

import java.math.BigDecimal;
import java.util.List;

public class OrderService {
    public OrderDto createOrder(List<OrderItemDto> orderItemDtoList) {
        BigDecimal netTotal = getNetTotal(orderItemDtoList);
        BigDecimal total = getTotal(orderItemDtoList);
        return new OrderDto(netTotal, getTax(total, netTotal), total, orderItemDtoList);
    }

    private BigDecimal getNetTotal(List<OrderItemDto> orderItemDtoList) {
        return orderItemDtoList.stream()
                .map(orderItemDto -> orderItemDto.netTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getTax(BigDecimal total, BigDecimal netTotal) {
        return total.add(netTotal.negate());
    }

    private BigDecimal getTotal(List<OrderItemDto> orderItemDtoList) {
        return orderItemDtoList.stream()
                .map(orderItemDto -> orderItemDto.total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
