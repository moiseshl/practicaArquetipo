package mx.com.axity.services.service;

import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.KeyboardTO;
import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.commons.to.ResponseTO;
import mx.com.axity.model.ComputerDO;

import java.util.List;

public interface IinventoryService {

    OrdersTO getOrder(int idOrder);
    ResponseTO createOrder(OrdersTO orderTO);
    ResponseTO createComputer(ComputerDO computerDO);

}
