package com.mgmetehan.accountAndUser.shared.model.resource;

import com.mgmetehan.accountAndUser.core.model.resource.BaseModelResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserResource extends BaseModelResource {
    private Long id;
    private String createdDate;
    private String updatedDate;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String password;
}