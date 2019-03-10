package pl.piotr.skoczylas.orderproject.service;

import pl.piotr.skoczylas.orderproject.dto.OrderItemDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OrderItemService {
    public OrderItemDto createOrderItem(BigDecimal netPrice, long quantity, int percentTax) {
        BigDecimal netTotal = getNetTotal(netPrice, quantity);
        return new OrderItemDto(netPrice, quantity, netTotal, getTotal(netTotal, percentTax));
    }

    private BigDecimal getNetTotal(BigDecimal netPrice, long quantity) {
        return netPrice.multiply(BigDecimal.valueOf(quantity));
    }

    private BigDecimal getTotal(BigDecimal netTotal, int precentTax) {
        return netTotal.add(netTotal
                .multiply(BigDecimal.valueOf(precentTax))
                .divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP));
    }
}
