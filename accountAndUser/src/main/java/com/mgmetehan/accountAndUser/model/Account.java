package com.mgmetehan.accountAndUser.model;

import com.mgmetehan.accountAndUser.core.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Account extends BaseModel {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @OneToMany(mappedBy = "account", cascade = CascadeType.MERGE, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<User> users = new ArrayList<>();

    @Override
    public <T extends BaseModel> void update(T entity) {
        var account = (Account) entity;

        if (Objects.nonNull(account.getName())) {
            name = account.getName();
        }
        if (Objects.nonNull(account.getType())) {
            type = account.getType();
        }
    }
}
