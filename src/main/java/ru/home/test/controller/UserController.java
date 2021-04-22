package ru.home.test.controller;

import javassist.NotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.home.test.service.UserService;
import ru.home.test.service.dto.UserDto;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("addUser")
    public String addUser(@RequestBody UserDto userDto) throws NotFoundException {
        return userService.addNewUser(userDto);
    }
}
