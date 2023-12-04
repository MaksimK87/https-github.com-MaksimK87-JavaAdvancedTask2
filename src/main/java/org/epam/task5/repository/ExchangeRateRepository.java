package org.epam.task5.repository;

import org.epam.task5.model.ExchangeRate;

public interface ExchangeRateRepository {

    ExchangeRate getExchangeRate(String fromCurrency, String toCurrency);

    void saveExchangeRate(ExchangeRate exchangeRate);


}
