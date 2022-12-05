package com.mgmetehan.accountAndUser.core.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseModelDto implements BaseDto {
    @Override
    public void validate() {
    }
}