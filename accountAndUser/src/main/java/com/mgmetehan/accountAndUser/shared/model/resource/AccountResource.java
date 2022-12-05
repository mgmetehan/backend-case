package com.mgmetehan.accountAndUser.shared.model.resource;

import com.mgmetehan.accountAndUser.core.model.resource.BaseModelResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountResource extends BaseModelResource {
    private Long id;
    private Long userId;
    private String createdDate;
    private String updatedDate;
    private String name;
    private Long type;
}