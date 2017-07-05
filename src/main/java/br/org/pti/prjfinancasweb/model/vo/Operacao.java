/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Operacao implements Serializable {

    
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private Cliente clienteRemetente;
    @Getter
    @Setter
    private Cliente clienteDestinatario;
    @Getter
    @Setter
    private ContaBancaria contaBancariaRemetente;
    @Getter
    @Setter
    private ContaBancaria contaBancariaDestinatario;
    @Getter
    @Setter
    private TipoOperacao tipoOperacao;
    @Getter
    @Setter
    private BigDecimal valor;

    public Operacao() {
    }

}
