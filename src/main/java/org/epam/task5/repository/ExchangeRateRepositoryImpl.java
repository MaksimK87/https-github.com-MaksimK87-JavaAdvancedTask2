package org.epam.task5.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.epam.task5.model.ExchangeRate;

public class ExchangeRateRepositoryImpl implements ExchangeRateRepository {

    private static final String EXCHANGE_DIR_PATH = "src/main/resources/exchange_rates/";

    @Override
    public ExchangeRate getExchangeRate(String fromCurrency, String toCurrency) {

        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(EXCHANGE_DIR_PATH + fromCurrency + toCurrency))) {
            return (ExchangeRate) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    @Override
    public void saveExchangeRate(ExchangeRate exchangeRate) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                EXCHANGE_DIR_PATH + exchangeRate.getFromCurrency() + exchangeRate.getToCurrency()))) {
            oos.writeObject(exchangeRate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
