package com.mgmetehan.accountAndUser.service;

import com.mgmetehan.accountAndUser.shared.model.dto.AccountDto;
import com.mgmetehan.accountAndUser.shared.model.dto.AccountUpdateDto;
import com.mgmetehan.accountAndUser.shared.model.resource.AccountResource;

import java.util.List;

public interface AccountService {
    AccountResource saveAccount(AccountDto dto);
    AccountResource getByAccountId(Long id);
    List<AccountResource> getAllAccounts();
    void deleteAccount(Long id);
    AccountResource updateAccount(Long id, AccountUpdateDto accountUpdateDto);
}
