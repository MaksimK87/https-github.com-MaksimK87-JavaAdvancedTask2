package org.epam.task5.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;

public class UserAccount implements Serializable {

    private Long id;

    private HashMap<String, BigDecimal> currencies = new HashMap<>();

    public UserAccount(long id) {

        this.id = id;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public HashMap<String, BigDecimal> getCurrencies() {

        return currencies;
    }

    public void setCurrencies(HashMap<String, BigDecimal> currencies) {

        this.currencies = currencies;
    }

    public void addCurrency(String currencyCode, BigDecimal amount) {

        currencies.put(currencyCode, amount);
    }

    public BigDecimal getCurrencyAmount(String currencyCode) {

        return currencies.getOrDefault(currencyCode, BigDecimal.ZERO);
    }

    @Override
    public String toString() {

        return "UserAccount{" +
                "id=" + id +
                ", currencies=" + currencies +
                '}';
    }
}
