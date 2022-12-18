package com.mgmetehan.accountAndUser.controller;

import com.mgmetehan.accountAndUser.ratelimit.RateLimiter;
import com.mgmetehan.accountAndUser.service.UserService;
import com.mgmetehan.accountAndUser.shared.endpoints.UserEndpoints;
import com.mgmetehan.accountAndUser.shared.exception.GenericResponse;
import com.mgmetehan.accountAndUser.shared.model.dto.UserDto;
import com.mgmetehan.accountAndUser.shared.model.resource.UserResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    @RateLimiter(limit = 5, time = 60_000)
    public ResponseEntity<UserResource> get(@PathVariable Long id, HttpSession session) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getByUserId(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResource>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAllUsers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new GenericResponse("User Deleted"));

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResource> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userUpdateDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.updateUser(id, userUpdateDto));
    }
}
