package mx.com.axity.services.facade;

import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.commons.to.ResponseTO;
import mx.com.axity.model.ComputerDO;
import mx.com.axity.model.OrdersDO;

import java.util.List;

public interface IinventoryFacade {

    OrdersTO getOrderById(int idOrder);
    ResponseTO createNewOrder(OrdersTO ordersTO);
    ResponseTO createNewComputer(ComputerDO computerDO);
}
