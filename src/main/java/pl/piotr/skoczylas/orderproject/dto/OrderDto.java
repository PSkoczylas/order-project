package pl.piotr.skoczylas.orderproject.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderDto {
    public BigDecimal netTotal;
    public BigDecimal tax;
    public BigDecimal total;

    public List<OrderItemDto> orderItemDtoList;

    public OrderDto(BigDecimal netTotal, BigDecimal tax, BigDecimal total, List<OrderItemDto> orderItemDtoList) {
        this.netTotal = netTotal;
        this.total = total;
        this.tax = tax;
        this.orderItemDtoList = orderItemDtoList;
        orderItemDtoList.forEach(orderItemDto -> orderItemDto.setOrder(this));
    }
}
