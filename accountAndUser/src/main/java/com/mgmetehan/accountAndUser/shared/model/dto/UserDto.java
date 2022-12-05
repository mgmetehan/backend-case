package com.mgmetehan.accountAndUser.shared.model.dto;

import com.mgmetehan.accountAndUser.core.model.dto.BaseModelDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto extends BaseModelDto {
    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String password;

    @Override
    public void validate() {

    }
}