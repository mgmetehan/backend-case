package com.mgmetehan.accountAndUser.controller;

import com.mgmetehan.accountAndUser.service.AccountService;
import com.mgmetehan.accountAndUser.shared.endpoints.AccountEndpoints;
import com.mgmetehan.accountAndUser.shared.exception.GenericResponse;
import com.mgmetehan.accountAndUser.shared.model.dto.AccountDto;
import com.mgmetehan.accountAndUser.shared.model.dto.AccountUpdateDto;
import com.mgmetehan.accountAndUser.shared.model.resource.AccountResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<AccountResource> get(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountService.getByAccountId(id));
    }

    @GetMapping
    public ResponseEntity<List<AccountResource>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountService.getAllAccounts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse> deleteAccount(@PathVariable("id") Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(new GenericResponse("User Deleted"));

    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountResource> updateAccount(@PathVariable("id") Long id, @RequestBody AccountUpdateDto accountUpdateDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountService.updateAccount(id, accountUpdateDto));
    }
}
