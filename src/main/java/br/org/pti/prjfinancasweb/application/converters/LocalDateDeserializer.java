package br.org.pti.prjfinancasweb.application.converters;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.time.LocalDate;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sara.so
 */

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    protected LocalDateDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
        return LocalDate.parse(parser.readValueAs(String.class));
    }
}
