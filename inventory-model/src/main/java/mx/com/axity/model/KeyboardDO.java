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
@Table(name = "keyboard", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class KeyboardDO implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_keyboard")
    private int idKeyboard;
    @Column(name = "brand")
    private String brand;
    @Column(name = "serial_number")
    private String serialNumber;
}
