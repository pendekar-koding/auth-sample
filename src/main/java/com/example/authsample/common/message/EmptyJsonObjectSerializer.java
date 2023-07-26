package com.example.authsample.common.message;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class EmptyJsonObjectSerializer extends StdSerializer<Object> {

    public EmptyJsonObjectSerializer() {
        this(null);
    }

    public EmptyJsonObjectSerializer(Class<Object> t) {
        super(t);
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeEndObject();
    }

    @Override
    public void serializeWithType(Object value, JsonGenerator gen, SerializerProvider serializers,
                                  TypeSerializer typeSer) throws IOException {
        serialize(value, gen, serializers);
    }
}

