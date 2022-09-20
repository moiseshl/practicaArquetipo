package mx.com.axity.services.service.impl;

import mx.com.axity.commons.to.*;
import mx.com.axity.model.*;
import mx.com.axity.persistence.*;
import mx.com.axity.services.service.IinventoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class inventoryServiceImpl implements IinventoryService {

    static final Logger LOG = LogManager.getLogger(inventoryServiceImpl.class);

    @Autowired
    ComputerDAO computerDAO;

    @Autowired
    KeyboardDAO keyboardDAO;
    @Autowired
    MouseDAO mouseDAO;
    @Autowired
    MonitorDAO monitorDAO;
    @Autowired
    OrdersDAO ordersDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public OrdersTO getOrder(int idOrder) {

        LOG.info("Consultando orders");

        OrdersDO ordersDO = this.ordersDAO.findByIdServiceOrder(idOrder);
        OrdersTO ordersTO = this.modelMapper.map(ordersDO, OrdersTO.class);

        List<ComputerDO> computersDO = this.computerDAO.findByIdServiceOrder(idOrder);
        Type computerDAOType = new TypeToken<List<ComputerTO>>() {}.getType();

        List<ComputerTO> computersTO = computersDO.stream().map(computerDO -> {
            KeyboardDO keyboardDO = this.keyboardDAO.findByIdKeyboard(computerDO.getIdKeyboard());
            KeyboardTO keyboardTO = this.modelMapper.map(keyboardDO, KeyboardTO.class);

            MonitorDO monitorDO = this.monitorDAO.findByIdMonitor(computerDO.getIdMonitor());
            MonitorTO monitorTO = this.modelMapper.map(monitorDO, MonitorTO.class);

            MouseDO mouseDO = this.mouseDAO.findByIdMouse(computerDO.getIdMouse());
            MouseTO mouseTO = this.modelMapper.map(mouseDO, MouseTO.class);

            ComputerTO computerTO = this.modelMapper.map(computerDO, ComputerTO.class);
            computerTO.setKeyboard(keyboardTO);
            computerTO.setMonitor(monitorTO);
            computerTO.setMouse(mouseTO);
            return computerTO;
        }).collect(Collectors.toList());

        ordersTO.setComputers(computersTO);

        return ordersTO;
    }

    public ResponseTO createOrder(OrdersTO ordersTO){
        OrdersDO ordersDO = this.modelMapper.map(ordersTO, OrdersDO.class);
        this.ordersDAO.save(ordersDO);
        ResponseTO response = new ResponseTO();



        response.setCode(201);
        response.setMessage("Se ha creado una orden");
        return response;
    }

    public ResponseTO createComputer(ComputerDO computerDO){

        this.computerDAO.save(computerDO);
        ResponseTO response = new ResponseTO();

        response.setCode(201);
        response.setMessage("Se ha creado una computer");
        return response;
    }
}
