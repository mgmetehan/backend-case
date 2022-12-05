package com.mgmetehan.accountAndUser.service.impl;

import com.mgmetehan.accountAndUser.converter.AccountConverter;
import com.mgmetehan.accountAndUser.repository.AccountRepository;
import com.mgmetehan.accountAndUser.service.AccountService;
import com.mgmetehan.accountAndUser.service.UserService;
import com.mgmetehan.accountAndUser.shared.model.dto.AccountDto;
import com.mgmetehan.accountAndUser.shared.model.resource.AccountResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountConverter accountConverter;
    private final AccountRepository accountRepository;
    private final UserService userService;

    @Override
    public AccountResource saveAccount(AccountDto dto) {
        var entity = accountConverter.toEntity(dto);
        var result = accountConverter.toResource(accountRepository.save(entity));
        userService.updateAccountId(dto.getUserId(),result);
        return result;
    }
}
