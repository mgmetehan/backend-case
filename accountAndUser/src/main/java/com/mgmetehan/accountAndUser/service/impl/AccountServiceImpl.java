package com.mgmetehan.accountAndUser.service.impl;

import com.mgmetehan.accountAndUser.converter.AccountConverter;
import com.mgmetehan.accountAndUser.repository.AccountRepository;
import com.mgmetehan.accountAndUser.service.AccountService;
import com.mgmetehan.accountAndUser.service.UserService;
import com.mgmetehan.accountAndUser.shared.exception.NotFoundException;
import com.mgmetehan.accountAndUser.shared.model.dto.AccountDto;
import com.mgmetehan.accountAndUser.shared.model.dto.AccountUpdateDto;
import com.mgmetehan.accountAndUser.shared.model.resource.AccountResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        userService.updateAccountId(dto.getUserId(), result);
        return result;
    }

    @Override
    public AccountResource getByAccountId(Long id) {
        var optionalAccount = accountRepository.findById(id);
        var account = optionalAccount.orElseThrow();
        return accountConverter.toResource(account);
    }

    @Override
    public List<AccountResource> getAllAccounts() {
        return accountRepository
                .findAll()
                .stream()
                .map(accountConverter::toResource)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        final var account = accountRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        account.getUsers().get(0).setId(null);
        accountRepository.deleteById(id);
    }

    @Override
    public AccountResource updateAccount(Long id, AccountUpdateDto accountUpdateDto) {
        final var theReal = accountRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        var forSave = accountConverter.toUpdateEntity(accountUpdateDto);
        theReal.update(forSave);

        return accountConverter
                .toResource(accountRepository.save(theReal));
    }
}
