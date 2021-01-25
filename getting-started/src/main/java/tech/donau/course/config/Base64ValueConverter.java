package tech.donau.course.config;

import org.eclipse.microprofile.config.spi.Converter;

// required
public class Base64ValueConverter implements Converter<Base64Value> {
    @Override
    public Base64Value convert(String s) {
        return new Base64Value(s);
    }
}
