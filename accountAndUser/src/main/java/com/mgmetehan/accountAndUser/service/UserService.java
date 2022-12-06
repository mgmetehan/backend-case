package com.mgmetehan.accountAndUser.service;

import com.mgmetehan.accountAndUser.shared.model.dto.UserDto;
import com.mgmetehan.accountAndUser.shared.model.resource.AccountResource;
import com.mgmetehan.accountAndUser.shared.model.resource.UserResource;

import java.util.List;

public interface UserService {
    UserResource saveUser(UserDto dto);
    UserResource getByUserId(Long id);
    List<UserResource> getAllUsers();
    void deleteUser(Long id);
    UserResource updateUser(Long id, UserDto userUpdateDto);
    UserResource updateAccountId(Long id, AccountResource userUpdateDto);
}
