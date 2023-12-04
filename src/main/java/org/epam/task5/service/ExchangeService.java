package org.epam.task5.service;

import java.math.BigDecimal;

import org.epam.task5.exception.InsufficientFundsException;
import org.epam.task5.exception.RateNotFoundException;

public interface ExchangeService {

    BigDecimal exchange(Long accountId, String fromCurrency, String toCurrency, BigDecimal amount)
            throws InsufficientFundsException, RateNotFoundException;
}
