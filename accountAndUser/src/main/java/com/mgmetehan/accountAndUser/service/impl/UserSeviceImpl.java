package com.mgmetehan.accountAndUser.service.impl;

import com.mgmetehan.accountAndUser.converter.UserConverter;
import com.mgmetehan.accountAndUser.repository.UserRepository;
import com.mgmetehan.accountAndUser.service.UserService;
import com.mgmetehan.accountAndUser.shared.model.dto.UserDto;
import com.mgmetehan.accountAndUser.shared.model.resource.UserResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserSeviceImpl implements UserService {

    private final UserConverter userConverter;
    private final UserRepository userRepository;

    @Override
    public UserResource saveUser(UserDto dto) {
        var entity = userConverter.toEntity(dto);
        return userConverter.toResource(userRepository.save(entity));
    }

    @Override
    public UserResource getByUserId(Long id) {
        var optionalUser = userRepository.findById(id);
        var user = optionalUser.orElseThrow();
        return userConverter.toResource(user);
    }
}
