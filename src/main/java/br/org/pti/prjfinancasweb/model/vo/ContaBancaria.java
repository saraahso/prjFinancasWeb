package br.org.pti.prjfinancasweb.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author sara.so
 */
@ToString
@EqualsAndHashCode
public class ContaBancaria implements Serializable {

    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private int numeroConta;
    @Getter
    @Setter
    private int digito;
    @Getter
    @Setter
    private BigDecimal saldo;
    @Getter
    @Setter
    private String token;
    @Setter
    @Getter
    private Cliente cliente;
    
    public ContaBancaria() {}
   
    
    
}
