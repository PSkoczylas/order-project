package pl.piotr.skoczylas.orderproject.service

import pl.piotr.skoczylas.orderproject.dto.OrderDto
import pl.piotr.skoczylas.orderproject.dto.OrderItemDto
import spock.lang.Specification
import spock.lang.Subject

class OrderServiceSpec extends Specification {
    @Subject
    OrderService orderService = new OrderService()

    def "should create order with correct data"() {
        given:
        OrderItemDto orderItem1 = new OrderItemDto(BigDecimal.valueOf(20), 4, BigDecimal.valueOf(80),
                BigDecimal.valueOf(88))
        OrderItemDto orderItem2 = new OrderItemDto(BigDecimal.valueOf(20.53), 4, BigDecimal.valueOf(82.12),
                BigDecimal.valueOf(89.51))
        OrderItemDto orderItem3 = new OrderItemDto(BigDecimal.valueOf(109.99), 1, BigDecimal.valueOf(109.99),
                BigDecimal.valueOf(135.29))
        List<OrderItemDto> orderItemDtoList = Arrays.asList(orderItem1, orderItem2, orderItem3)
        when:
        OrderDto order = orderService.createOrder(orderItemDtoList)
        then:
        order.orderItemDtoList.size() == 3
        order.netTotal == 272.11
        order.total == 312.8
        order.tax == order.total - order.netTotal
    }
}
