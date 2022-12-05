package com.mgmetehan.accountAndUser.service;

import com.mgmetehan.accountAndUser.shared.model.dto.UserDto;
import com.mgmetehan.accountAndUser.shared.model.resource.UserResource;

public interface UserService {
    UserResource saveUser(UserDto dto);

    UserResource getByUserId(Long id);
}
