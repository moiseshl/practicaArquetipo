package mx.com.axity.commons.to;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResponseTO implements Serializable {

    private static final long serialVersionUID = 7449115534572237478L;
    private int code;
    private String message;

}