package com.mgmetehan.accountAndUser.controller;

import com.mgmetehan.accountAndUser.service.AccountService;
import com.mgmetehan.accountAndUser.shared.exception.GenericResponse;
import com.mgmetehan.accountAndUser.shared.model.dto.AccountDto;
import com.mgmetehan.accountAndUser.shared.model.dto.AccountUpdateDto;
import com.mgmetehan.accountAndUser.shared.model.resource.AccountResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

    @InjectMocks
    private AccountController accountController;

    @Mock
    private AccountService accountService;

    @Test
    public void testSave() {
        var accountDto = Mockito.mock(AccountDto.class);
        var expectedAccountResource = Mockito.mock(AccountResource.class);

        when(accountService.saveAccount(accountDto)).thenReturn(expectedAccountResource);
        ResponseEntity<AccountResource> response = accountController.save(accountDto);

        verify(accountDto).validate();
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedAccountResource, response.getBody());
    }

    @Test
    void testGet() {
        var expectedAccountResource = Mockito.mock(AccountResource.class);
        expectedAccountResource.setId(1L);
        expectedAccountResource.setName("Test Account");

        when(accountService.getByAccountId(1L)).thenReturn(expectedAccountResource);
        ResponseEntity<AccountResource> response = accountController.get(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedAccountResource, response.getBody());
    }

    @Test
    void testGetAll() {
        var expectedAccountResourcesList = new java.util.ArrayList<>(Collections.singletonList(Mockito.mock(AccountResource.class)));
        var expectedAccountResource = Mockito.mock(AccountResource.class);
        expectedAccountResource.setId(1L);
        expectedAccountResource.setName("Test Account 1");
        expectedAccountResourcesList.add(expectedAccountResource);

        when(accountService.getAllAccounts()).thenReturn(expectedAccountResourcesList);
        ResponseEntity<List<AccountResource>> response = accountController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedAccountResourcesList, response.getBody());
    }

    @Test
    void testDeleteAccount() {
        GenericResponse expectedResponse = new GenericResponse("User Deleted");
        // var expectedResponse = Mockito.mock(GenericResponse.class);

        ResponseEntity<GenericResponse> response = accountController.deleteAccount(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
        verify(accountService).deleteAccount(1L);
    }

    @Test
    void testUpdateAccount() {
        var accountUpdateDto = Mockito.mock(AccountUpdateDto.class);
        var expectedAccountResource =  Mockito.mock(AccountResource.class);
        accountUpdateDto.setName("Test Account");
        expectedAccountResource.setId(1L);
        expectedAccountResource.setName("Test Account");

        when(accountService.updateAccount(1L, accountUpdateDto)).thenReturn(expectedAccountResource);
        ResponseEntity<AccountResource> response = accountController.updateAccount(1L, accountUpdateDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedAccountResource, response.getBody());
    }
}
