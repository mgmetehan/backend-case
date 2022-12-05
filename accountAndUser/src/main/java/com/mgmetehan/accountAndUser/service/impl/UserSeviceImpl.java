package com.mgmetehan.accountAndUser.service.impl;

import com.mgmetehan.accountAndUser.converter.UserConverter;
import com.mgmetehan.accountAndUser.model.Account;
import com.mgmetehan.accountAndUser.repository.UserRepository;
import com.mgmetehan.accountAndUser.service.UserService;
import com.mgmetehan.accountAndUser.shared.exception.NotFoundException;
import com.mgmetehan.accountAndUser.shared.model.dto.UserDto;
import com.mgmetehan.accountAndUser.shared.model.resource.AccountResource;
import com.mgmetehan.accountAndUser.shared.model.resource.UserResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<UserResource> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(userConverter::toResource)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        final var user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        userRepository.deleteById(id);
    }

    @Override
    public UserResource updateUser(Long id, UserDto userUpdateDto) {
        final var theReal = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        var forSave = userConverter.toEntity(userUpdateDto);
        theReal.update(forSave);

        return userConverter
                .toResource(userRepository.save(theReal));
    }

    @Override
    public UserResource updateAccountId(Long id, AccountResource accountResource) {
        final var theReal = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));

        var account=new Account();
        account.setId(accountResource.getId());
        theReal.setAccount(account);

        return userConverter
                .toResource(userRepository.save(theReal));
    }
}
