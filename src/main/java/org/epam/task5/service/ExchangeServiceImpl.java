package org.epam.task5.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

import org.epam.task5.exception.AccountNotFoundException;
import org.epam.task5.exception.InsufficientFundsException;
import org.epam.task5.exception.RateNotFoundException;
import org.epam.task5.model.ExchangeRate;
import org.epam.task5.model.UserAccount;
import org.epam.task5.repository.ExchangeRateRepository;
import org.epam.task5.repository.UserAccountRepository;

public class ExchangeServiceImpl implements ExchangeService {

    private UserAccountRepository accountRepository;
    private ExchangeRateRepository rateRepository;
    private ReentrantLock lock = new ReentrantLock();

    public ExchangeServiceImpl(UserAccountRepository accountRepository, ExchangeRateRepository rateRepository) {

        this.accountRepository = accountRepository;
        this.rateRepository = rateRepository;
    }

    @Override
    public BigDecimal exchange(Long accountId, String fromCurrency, String toCurrency, BigDecimal amount)
            throws InsufficientFundsException, RateNotFoundException {

        lock.lock();
        UserAccount userAccount = accountRepository.getAccount(accountId);
        lock.unlock();
        if (userAccount == null) {
            throw new AccountNotFoundException("Account not found");
        }
        lock.lock();
        BigDecimal fromAmount = userAccount.getCurrencyAmount(fromCurrency);
        if (fromAmount.compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        ExchangeRate exchangeRate = rateRepository.getExchangeRate(fromCurrency, toCurrency);
        if (exchangeRate == null) {
            throw new RateNotFoundException("Exchange rate not found");
        }

        BigDecimal toAmount = amount.multiply(exchangeRate.getRate());
        userAccount.addCurrency(toCurrency, (userAccount.getCurrencyAmount(toCurrency).add(toAmount)));
        userAccount.addCurrency(fromCurrency, (userAccount.getCurrencyAmount(fromCurrency).subtract(amount)));

        accountRepository.saveAccount(userAccount);
        lock.unlock();
        return toAmount;
    }
}

