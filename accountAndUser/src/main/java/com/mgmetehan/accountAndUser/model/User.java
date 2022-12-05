package com.mgmetehan.accountAndUser.model;

import com.mgmetehan.accountAndUser.core.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "usr")
public class User extends BaseModel {
    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @Override
    public <T extends BaseModel> void update(T entity) {

    }
}
