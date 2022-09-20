package mx.com.axity.services.facade;

import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.MouseTO;
import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class inventoryFacadeTest extends BaseTest {

    @Test
    public void ShouldReturnAllUsers() {

        List<OrdersTO> orders = this.inventoryFacade.getAllOrders();

        Assert.assertEquals(1, orders.size());
    }
}