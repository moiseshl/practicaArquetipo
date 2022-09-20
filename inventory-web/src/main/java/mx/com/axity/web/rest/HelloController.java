package mx.com.axity.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.commons.to.ResponseTO;
import mx.com.axity.model.ComputerDO;
import mx.com.axity.services.facade.IinventoryFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("serviceorder/v1")
@Api(value="inventory")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    IinventoryFacade IinventoryFacade;


    @GetMapping(value = "/order/{id}", produces = "application/json")
    @ApiOperation(value = "Buscar order",
            notes = "Retorna order",
            response = OrdersTO.class,
            produces = "application/json")
    public ResponseEntity<OrdersTO> getOrderById(@PathVariable("id") int id) {
        OrdersTO order = this.IinventoryFacade.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping(value = "/neworder", produces = "application/json")
    @ApiOperation(value = "nueva order",
            notes = "Retorna response",
            response = ResponseTO.class,
            produces = "application/json")
    public ResponseEntity<ResponseTO> createOrder(@RequestBody OrdersTO request) {
        LOG.info("Se invoca POST /neworder");
        ResponseTO responseValue = this.IinventoryFacade.createNewOrder(request);
        return new ResponseEntity<ResponseTO>(responseValue, HttpStatus.CREATED);
    }

    @PostMapping(value = "/newcomputer", produces = "application/json")
    @ApiOperation(value = "nueva computer",
            notes = "Retorna response",
            response = ResponseTO.class,
            produces = "application/json")
    public ResponseEntity<ResponseTO> createComputer(@RequestBody ComputerDO request) {
        LOG.info("Se invoca POST /neworder");
        ResponseTO responseValue = this.IinventoryFacade.createNewComputer(request);
        return new ResponseEntity<ResponseTO>(responseValue, HttpStatus.CREATED);
    }


    @GetMapping(value = "/ping", produces = "application/json")
    @ApiOperation(value = "Ping",
            notes = "Pong",
            produces = "application/json")
    public ResponseEntity test() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
}
