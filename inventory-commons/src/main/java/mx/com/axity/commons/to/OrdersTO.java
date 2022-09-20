package mx.com.axity.commons.to;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class OrdersTO implements Serializable {

    private int idServiceOrders;
    private List<ComputerTO> computers;
}
