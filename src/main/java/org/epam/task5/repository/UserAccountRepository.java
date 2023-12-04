package org.epam.task5.repository;

import org.epam.task5.model.UserAccount;

public interface UserAccountRepository {

    UserAccount getAccount(Long accountId);

    void saveAccount(UserAccount userAccount);
}
