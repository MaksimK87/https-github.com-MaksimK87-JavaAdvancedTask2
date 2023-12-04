package org.epam.task5;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.epam.task5.model.ExchangeRate;
import org.epam.task5.model.UserAccount;
import org.epam.task5.repository.ExchangeRateRepository;
import org.epam.task5.repository.UserAccountRepository;
import org.epam.task5.service.ExchangeServiceImpl;

public class DataInitializer {

    private static List<UserAccount> userAccountList = new ArrayList<>();

    public static void initialize(UserAccountRepository accountRepository, ExchangeRateRepository rateRepository) {

        UserAccount account1 = new UserAccount(1);
        account1.addCurrency("USD", new BigDecimal("1000"));
        account1.addCurrency("EUR", new BigDecimal("800"));
        accountRepository.saveAccount(account1);

        ExchangeRate rate1 = new ExchangeRate("USD", "EUR", new BigDecimal("0.8"));
        rateRepository.saveExchangeRate(rate1);

        UserAccount account2 = new UserAccount(2);
        account2.addCurrency("BYN", new BigDecimal("1100"));
        account2.addCurrency("EUR", new BigDecimal("600"));
        accountRepository.saveAccount(account2);

        ExchangeRate rate2 = new ExchangeRate("BYN", "EUR", new BigDecimal("0.28"));
        rateRepository.saveExchangeRate(rate2);
        userAccountList.add(account1);
        userAccountList.add(account2);
    }
}
