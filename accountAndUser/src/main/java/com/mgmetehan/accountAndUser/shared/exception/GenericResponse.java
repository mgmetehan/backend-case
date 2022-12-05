package com.mgmetehan.accountAndUser.shared.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class GenericResponse extends Throwable {
    private String message;
}