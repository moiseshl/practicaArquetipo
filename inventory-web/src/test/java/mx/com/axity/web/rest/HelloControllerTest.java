package mx.com.axity.web.rest;

import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.MouseTO;
import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.web.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;

import java.util.List;

public class HelloControllerTest extends BaseTest {

    @Test
    public void exampleTest() {

        //this.entityManager.persist(new UserDO("Javier", "Rodriguez", 1));

        List<OrdersTO> orders = this.inventoryFacade.getAllOrders();

        Assert.assertNotNull(orders);
        Assert.assertEquals(2, orders.size());
    }
}
