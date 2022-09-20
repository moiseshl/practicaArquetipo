package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.*;
import mx.com.axity.model.ComputerDO;
import mx.com.axity.model.OrdersDO;
import mx.com.axity.services.facade.IinventoryFacade;
import mx.com.axity.services.service.IinventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class inventoryFacade implements IinventoryFacade {

    @Autowired
    private IinventoryService inventoryService;

    public OrdersTO getOrderById(int idOrder) {
        return this.inventoryService.getOrder(idOrder);
    }
    public ResponseTO createNewOrder(OrdersTO ordersTO) { return this.inventoryService.createOrder(ordersTO); }

    public ResponseTO createNewComputer(ComputerDO computerDO) { return this.inventoryService.createComputer(computerDO); }

}
