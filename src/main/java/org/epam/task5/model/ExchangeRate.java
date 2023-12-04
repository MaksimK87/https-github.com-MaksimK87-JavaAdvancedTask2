package org.epam.task5.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ExchangeRate implements Serializable {

    private String fromCurrency;
    private String toCurrency;
    private BigDecimal rate;

    public ExchangeRate(String fromCurrency, String toCurrency, BigDecimal rate) {

        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.rate = rate;
    }

    public String getFromCurrency() {

        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {

        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {

        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {

        this.toCurrency = toCurrency;
    }

    public BigDecimal getRate() {

        return rate;
    }

    public void setRate(BigDecimal rate) {

        this.rate = rate;
    }
}
