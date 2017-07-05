package br.org.pti.prjfinancasweb.model.vo;

import br.org.pti.prjfinancasweb.application.converters.LocalDateDeserializer;
import br.org.pti.prjfinancasweb.application.converters.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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
public class Cliente implements Serializable {

    @Setter
    @Getter
    private Integer id;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String cpf;
    @Getter
    @Setter
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dataNascimento;
    @Getter
    @Setter
    private BigDecimal renda;

    public Cliente() { }
}
