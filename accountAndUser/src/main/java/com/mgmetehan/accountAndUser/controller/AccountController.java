package com.mgmetehan.accountAndUser.controller;

import com.mgmetehan.accountAndUser.service.AccountService;
import com.mgmetehan.accountAndUser.shared.endpoints.AccountEndpoints;
import com.mgmetehan.accountAndUser.shared.model.dto.AccountDto;
import com.mgmetehan.accountAndUser.shared.model.resource.AccountResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AccountEndpoints.ACCOUNTS)
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResource> save(@RequestBody AccountDto dto) {
        dto.validate();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(accountService.saveAccount(dto));
    }
}
