package tech.donau.course.config;

import io.quarkus.jsonb.JsonbConfigCustomizer;

import javax.json.bind.JsonbConfig;

public class JsonbConverterConfig implements JsonbConfigCustomizer {
    @Override
    public void customize(JsonbConfig jsonbConfig) {
        jsonbConfig.getAsMap(); // can configure how jsonb responses are returned
    }
}
