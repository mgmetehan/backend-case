package com.mgmetehan.accountAndUser.converter;

import com.mgmetehan.accountAndUser.core.converter.BaseConverter;
import com.mgmetehan.accountAndUser.model.User;
import com.mgmetehan.accountAndUser.shared.model.dto.UserDto;
import com.mgmetehan.accountAndUser.shared.model.resource.UserResource;
import com.mgmetehan.accountAndUser.shared.util.DateUtil;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements BaseConverter<UserDto, User, UserResource> {

    @Override
    public UserResource toResource(User entity) {
        var userResource = new UserResource();
        userResource.setId(entity.getId());
        userResource.setCreatedDate(DateUtil.toDate(entity.getCreatedDateTime()));
        userResource.setUpdatedDate(DateUtil.toDate(entity.getLastModifiedDate()));
        userResource.setName(entity.getName());
        userResource.setSurname(entity.getSurname());
        userResource.setEmail(entity.getEmail());
        userResource.setPhoneNumber(entity.getPhoneNumber());
        userResource.setPassword(entity.getPassword());

        return userResource;
    }

    @Override
    public User toEntity(UserDto dto) {
        var user = new User();
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setPassword(dto.getPassword());

        return user;
    }
}
