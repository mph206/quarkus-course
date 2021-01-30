package tech.donau.course.config;

import io.quarkus.arc.config.ConfigProperties;

import javax.validation.constraints.Size;
import java.util.Optional;


@ConfigProperties(prefix="greeting")
// Ideally want to implement this using an interface
public class GreetingConfig {

    // get values from application.properties
    @Size(max = 10)
    private String name;
    private String suffix = "!";
    private Optional<String> prefix;
    private CountryConfig country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setPrefix(Optional<String> prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public CountryConfig getCountry() {
        return country;
    }

    public void setCountry(CountryConfig country) {
        this.country = country;
    }

    public static class CountryConfig {
        String name;
        Integer id;

        public String getName() {
            return name;
        }

        public Integer getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}
