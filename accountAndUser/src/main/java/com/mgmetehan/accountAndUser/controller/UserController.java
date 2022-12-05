package com.mgmetehan.accountAndUser.controller;

import com.mgmetehan.accountAndUser.service.UserService;
import com.mgmetehan.accountAndUser.shared.endpoints.UserEndpoints;
import com.mgmetehan.accountAndUser.shared.model.dto.UserDto;
import com.mgmetehan.accountAndUser.shared.model.resource.UserResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserEndpoints.USERS)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResource> save(@RequestBody UserDto dto) {
        dto.validate();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.saveUser(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResource> get(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getByUserId(id));
    }
}
