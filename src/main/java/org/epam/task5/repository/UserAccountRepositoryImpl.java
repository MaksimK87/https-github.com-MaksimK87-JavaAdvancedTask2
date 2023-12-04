package org.epam.task5.repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.epam.task5.model.UserAccount;

public class UserAccountRepositoryImpl implements UserAccountRepository {

    private static final String ACCOUNT_DIR_PATH = "src/main/resources/user_accounts/";

    @Override
    public UserAccount getAccount(Long accountId) {

        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(ACCOUNT_DIR_PATH + accountId))) {
            return (UserAccount) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    @Override
    public void saveAccount(UserAccount userAccount) {

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ACCOUNT_DIR_PATH + userAccount.getId()))) {
            oos.writeObject(userAccount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
