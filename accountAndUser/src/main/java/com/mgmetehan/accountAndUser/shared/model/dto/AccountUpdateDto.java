package com.mgmetehan.accountAndUser.shared.model.dto;

import com.mgmetehan.accountAndUser.core.model.dto.BaseModelDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountUpdateDto extends BaseModelDto {
    private String name;
    private Long type;

    @Override
    public void validate() {

    }
}