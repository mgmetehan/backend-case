package com.mgmetehan.accountAndUser.shared.endpoints;

import com.mgmetehan.accountAndUser.core.endpoints.BaseEndpoints;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountEndpoints extends BaseEndpoints {
    public static final String ACCOUNTS = BASE + "/accounts";
    public static final String TEST = ACCOUNTS + "/test";
}