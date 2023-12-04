package org.epam.task5;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.epam.task5.repository.ExchangeRateRepository;
import org.epam.task5.repository.ExchangeRateRepositoryImpl;
import org.epam.task5.repository.UserAccountRepository;
import org.epam.task5.repository.UserAccountRepositoryImpl;
import org.epam.task5.service.ExchangeService;
import org.epam.task5.service.ExchangeServiceImpl;

public class ExchangeApp {

    public static void main(String[] args)
            throws InterruptedException {

        UserAccountRepository accountRepository = new UserAccountRepositoryImpl();
        ExchangeRateRepository rateRepository = new ExchangeRateRepositoryImpl();
        DataInitializer.initialize(accountRepository, rateRepository);
        ExchangeService exchangeService = new ExchangeServiceImpl(accountRepository, rateRepository);

      ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i < 5; i++) {
            executorService.submit(() -> {
                try {
                    BigDecimal exchangedAmount1 = exchangeService.exchange(1L, "USD", "EUR", new BigDecimal("100"));
                    BigDecimal exchangedAmount2 = exchangeService.exchange(2L, "BYN", "EUR", new BigDecimal("100"));
                    System.out.println("Exchanged Amount1: " + exchangedAmount1);
                    System.out.println("Exchanged Amount2: " + exchangedAmount2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        Thread.sleep(2000);
        System.out.println(accountRepository.getAccount(1L));
        System.out.println(accountRepository.getAccount(2L));
    }

}
