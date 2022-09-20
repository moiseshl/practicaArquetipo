package mx.com.axity.services.service;

import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class inventoryServiceTest extends BaseTest {

    @Test
    public void exampleTest() {

        List<ComputerTO> computers = this.inventoryService.getComputers();

        Assert.assertEquals(1, computers.size());
    }
}
