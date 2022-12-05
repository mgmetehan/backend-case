package com.mgmetehan.accountAndUser.shared.endpoints;

import com.mgmetehan.accountAndUser.core.endpoints.BaseEndpoints;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserEndpoints extends BaseEndpoints {
    public static final String USERS = BASE + "/users";
    public static final String TEST = USERS + "/test";
}