package tech.donau.crypto.data;

import javax.json.bind.annotation.JsonbProperty;

public class Currency {
    public String id;
    public String symbol;
    public String name;
    @JsonbProperty("price_usd") // lets us use variable name that doesn't't match api data
    public String priceUsd;

    public Currency() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }
}
