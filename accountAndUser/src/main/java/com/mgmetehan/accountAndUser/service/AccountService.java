package com.mgmetehan.accountAndUser.service;

import com.mgmetehan.accountAndUser.shared.model.dto.AccountDto;
import com.mgmetehan.accountAndUser.shared.model.resource.AccountResource;

public interface AccountService {
    AccountResource saveAccount(AccountDto dto);
}
