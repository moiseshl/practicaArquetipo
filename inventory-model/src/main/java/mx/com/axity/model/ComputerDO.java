package mx.com.axity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "computer", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class ComputerDO implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_computer")
    private int idComputer;
    @Column(name = "brand")
    private String brand;
    @Column(name = "id_monitor")
    private int idMonitor;
    @Column(name = "serial_number")
    private String serialNumber;
    @Column(name = "id_mouse")
    private int idMouse;
    @Column(name = "id_keyboard")
    private int idKeyboard;
    @Column(name = "id_order")
    private int idServiceOrder;

}
