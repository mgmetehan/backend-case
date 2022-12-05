package com.mgmetehan.accountAndUser.converter;

import com.mgmetehan.accountAndUser.core.converter.BaseConverter;
import com.mgmetehan.accountAndUser.model.Account;
import com.mgmetehan.accountAndUser.model.AccountType;
import com.mgmetehan.accountAndUser.model.User;
import com.mgmetehan.accountAndUser.shared.model.dto.AccountDto;
import com.mgmetehan.accountAndUser.shared.model.resource.AccountResource;
import com.mgmetehan.accountAndUser.shared.util.DateUtil;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AccountConverter implements BaseConverter<AccountDto, Account, AccountResource> {
    @Override
    public AccountResource toResource(Account entity) {
        var accountResource = new AccountResource();
        accountResource.setId(entity.getId());
        accountResource.setUserId(entity.getUsers().get(0).getId());
        accountResource.setCreatedDate(DateUtil.toDate(entity.getCreatedDateTime()));
        accountResource.setUpdatedDate(DateUtil.toDate(entity.getLastModifiedDate()));
        accountResource.setName(entity.getName());
        accountResource.setType(entity.getType().getDatabaseId());
        return accountResource;
    }

    @Override
    public Account toEntity(AccountDto dto) {
        var account = new Account();
        account.setName(dto.getName());

        var user = new User();
        user.setId(dto.getUserId());

        account.setUsers(Collections.singletonList(user));
        account.setType(AccountType.fromDatabaseId(dto.getType()));

        return account;
    }
}
