package pl.piotr.skoczylas.orderproject.service

import spock.lang.Specification
import spock.lang.Subject

class OrderItemServiceSpec extends Specification {
    @Subject
    def orderItemService = new OrderItemService()

    def "should create order items with correct data"() {
        when:
        def orderItem1 = orderItemService.createOrderItem(BigDecimal.valueOf(20), 4, 10)
        def orderItem2 = orderItemService.createOrderItem(BigDecimal.valueOf(20.53), 4, 9)
        def orderItem3 = orderItemService.createOrderItem(BigDecimal.valueOf(109.99), 1, 23)
        then:
        orderItem1.netTotal == 80
        orderItem2.netTotal == 82.12
        orderItem3.netTotal == 109.99
        orderItem1.total == 88
        orderItem2.total == 89.51
        orderItem3.total == 135.29
    }
}
