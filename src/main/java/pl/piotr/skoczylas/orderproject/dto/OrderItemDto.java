package pl.piotr.skoczylas.orderproject.dto;

import java.math.BigDecimal;

// w normalnym projekcie dalbym gettery i settery, a pola prywatne, ale tutaj nie bede sie w to bawil
public class OrderItemDto {
    public BigDecimal netPrice;
    public long quantity;
    public BigDecimal netTotal;
    public BigDecimal total;
    public OrderDto order;

    public OrderItemDto(BigDecimal netPrice, long quantity, BigDecimal netTotal, BigDecimal total) {
        this.netPrice = netPrice;
        this.quantity = quantity;
        this.netTotal = netTotal;
        this.total = total;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }
}
