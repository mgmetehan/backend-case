package com.mgmetehan.accountAndUser.shared.model.dto;

import com.mgmetehan.accountAndUser.core.model.dto.BaseModelDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountDto extends BaseModelDto {
    private String name;
    private Long userId;
    private Long type;

    @Override
    public void validate() {

    }
}