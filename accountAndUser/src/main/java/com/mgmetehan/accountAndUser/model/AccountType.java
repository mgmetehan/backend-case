package com.mgmetehan.accountAndUser.model;

import lombok.Getter;

@Getter
public enum AccountType {
    INDIVIDUAL(1L, 1L),
    CORPORATE(0L, 2L);

    private final Long displayValue;
    private final Long databaseId;


    AccountType(Long displayValue, Long databaseId) {
        this.displayValue = displayValue;
        this.databaseId = databaseId;
    }


    public static AccountType fromDisplayValue(Long id) {
        for (AccountType value : AccountType.values()) {
            if (value.displayValue.equals(id)) {
                return value;
            }
        }
        return null;
    }

    public static AccountType fromDatabaseId(Long id) {
        for (AccountType value : AccountType.values()) {
            if (value.databaseId.equals(id)) {
                return value;
            }
        }
        return null;
    }
}