package com.leonovets.ttweatherapi.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serial;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Custom Json serializer for Date Objects.
 *
 * @author Mikhail.Leonovets
 * @since 03/22/2023 - 16:35
 */
@Component
public class CustomDateSerializer extends StdSerializer<Date> {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Default constructor.
     */
    public CustomDateSerializer() {
        this(null);
    }

    protected CustomDateSerializer(final Class<Date> type) {
        super(type);
    }

    @Override
    public void serialize(final Date value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {
        gen.writeString(formatter.format(value));
    }
}
