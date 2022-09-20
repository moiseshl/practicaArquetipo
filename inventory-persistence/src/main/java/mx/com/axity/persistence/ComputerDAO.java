package mx.com.axity.persistence;

import mx.com.axity.model.ComputerDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComputerDAO extends CrudRepository<ComputerDO, Long> {

    List<ComputerDO> findByIdServiceOrder(int idOrder);
    ComputerDO save(ComputerDO computerDO);
}
