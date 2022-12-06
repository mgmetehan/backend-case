package com.mgmetehan.accountAndUser.controller;

import com.mgmetehan.accountAndUser.service.UserService;
import com.mgmetehan.accountAndUser.shared.model.dto.AccountUpdateDto;
import com.mgmetehan.accountAndUser.shared.model.dto.UserDto;
import com.mgmetehan.accountAndUser.shared.model.resource.UserResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    void testSave() {
        var userDto = Mockito.mock(UserDto.class);
        userDto.setName("test");
        userDto.setPassword("password");
        var expectedUserResource = Mockito.mock(UserResource.class);
        expectedUserResource.setId(1L);
        expectedUserResource.setName("test");

        when(userService.saveUser(userDto)).thenReturn(expectedUserResource);
        ResponseEntity<UserResource> response = userController.save(userDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedUserResource, response.getBody());
    }


    @Test
    public void testUpdateUser() {
        var userUpdateDto = Mockito.mock(UserDto.class);
        var userResource =Mockito.mock(UserResource.class);
        userUpdateDto.setName("Alice");
        userResource.setId(1L);

        when(userService.updateUser(1L, userUpdateDto)).thenReturn(userResource);

        ResponseEntity<UserResource> response = userController.updateUser(1L, userUpdateDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userResource, response.getBody());
    }

}
